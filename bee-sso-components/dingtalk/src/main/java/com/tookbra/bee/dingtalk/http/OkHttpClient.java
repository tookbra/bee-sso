package com.tookbra.bee.dingtalk.http;


import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.enums.HttpClientEnum;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.dingtalk.utils.StringUtil;
import com.tookbra.bee.sso.core.utils.JackSonUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author tookbra
 * @date 2019/1/10
 * @description
 */
@Slf4j
public class OkHttpClient extends HttpClientFactory implements HttpClient  {


    okhttp3.OkHttpClient okHttpClient;


    @Override
    public void init(DingTalkProperties.HttpConfig httpConfig, DingTalkRepository dingTalkRepository) {
        this.httpConfig = httpConfig;
        this.dingTalkRepository = dingTalkRepository;
        this.createHttpClient();
    }

    private void createHttpClient() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(super.httpConfig.getMaxTotalConn());
        dispatcher.setMaxRequestsPerHost(super.httpConfig.getMaxConnPerHost());

        ConnectionPool connectionPool = new ConnectionPool(super.httpConfig.getIdleConnTotal(),
                super.httpConfig.getIdleConnTimeout(), TimeUnit.SECONDS);

        okhttp3.OkHttpClient.Builder build = new okhttp3.OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .connectionPool(connectionPool)
                .connectTimeout(super.httpConfig.getConnectionTimeout(), TimeUnit.SECONDS);
        if(super.httpConfig.isEnableProxy()) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(super.httpConfig.getProxyUri(),
                    super.httpConfig.getProxyPort());
            Proxy proxy = new Proxy(super.httpConfig.getProxyType(), inetSocketAddress);
            build.proxy(proxy);
        }
        okHttpClient = build.build();
    }

    @Override
    public String post(String url, Map<String, Object> params) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("json"),
                params == null ? null : JackSonUtil.objectMapper.writeValueAsString(params));
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return this.filterResponse(response);
    }

    @Override
    public String get(String url, Map<String, Object> param) throws IOException {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if(param != null) {
                param.forEach((k, v) -> uriBuilder.setParameter(k, StringUtil.convertToString(v)));
            }

            Request request = new Request.Builder().url(uriBuilder.toString()).build();
            Response response = okHttpClient.newCall(request).execute();
            return this.filterResponse(response);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    @Override
    public String getName() {
        return HttpClientEnum.OKHTTP.name();
    }

    /**
     *
     * @param response
     * @return
     * @throws IOException
     */
    private String filterResponse(Response response) throws IOException {
        if (response.isSuccessful()) {
            String result = response.body().string();
            super.filterResult(result);
            return result;
        } else {
            throw new HttpResponseException(response.code(), response.message());
        }
    }
}
