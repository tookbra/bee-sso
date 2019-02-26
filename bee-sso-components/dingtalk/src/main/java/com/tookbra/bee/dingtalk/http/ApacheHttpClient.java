package com.tookbra.bee.dingtalk.http;

import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.HttpClientEnum;
import com.tookbra.bee.dingtalk.exception.DingTalkException;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.dingtalk.utils.StringUtil;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author tookbra
 * @date 2019/1/10
 * @description
 */
@Slf4j
public class ApacheHttpClient extends HttpClientFactory implements HttpClient {

    CloseableHttpClient httpClient;

    @Override
    public void init(DingTalkProperties.HttpConfig httpConfig, DingTalkRepository dingTalkRepository) {
        this.httpConfig = httpConfig;
        this.dingTalkRepository = dingTalkRepository;
        this.createHttpClient();
    }

    private void createHttpClient() {
        PoolingHttpClientConnectionManager poolHttpManager = new PoolingHttpClientConnectionManager();
        poolHttpManager.setMaxTotal(super.httpConfig.getMaxTotalConn());
        poolHttpManager.setDefaultMaxPerRoute(super.httpConfig.getMaxConnPerHost());

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(super.httpConfig.getConnectionRequestTimeout())
                .setConnectTimeout(super.httpConfig.getConnectionTimeout())
                .setSocketTimeout(super.httpConfig.getSoTimeout())
                .setRedirectsEnabled(super.httpConfig.isRetry())
                .build();

        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(poolHttpManager)
                .setProxy(super.httpConfig.isEnableProxy() ? new HttpHost(super.httpConfig.getProxyUri(),
                        super.httpConfig.getProxyPort(), super.httpConfig.getProxyType().name().toLowerCase()) : null)
                .build();
    }

    @Override
    public String post(String url, Map<String, Object> param) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        if(param != null) {
            StringEntity se = new StringEntity(JackSonUtil.objectMapper.writeValueAsString(param), ContentType.APPLICATION_JSON);
            httpPost.setEntity(se);
        }

        try(CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            return this.filterResponse(httpResponse);
        } finally {
            httpPost.releaseConnection();
        }
    }

    @Override
    public String get(String url, Map<String, Object> param) throws IOException {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if(param !=  null) {
                param.forEach((k, v) -> uriBuilder.setParameter(k, StringUtil.convertToString(v)));
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                String result = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                super.filterResult(result);
                return result;
            } finally {
                httpGet.releaseConnection();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    @Override
    public String getName() {
        return HttpClientEnum.APACHE.name();
    }

    /**
     *
     * @param response
     * @return
     * @throws IOException
     */
    private String filterResponse(CloseableHttpResponse response) throws IOException, DingTalkException {
        StatusLine statusLine = response.getStatusLine();
        if(statusLine.getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
            super.filterResult(result);
            return result;
        } else {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
    }
}
