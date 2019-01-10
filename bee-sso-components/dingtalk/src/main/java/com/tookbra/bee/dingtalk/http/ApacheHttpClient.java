package com.tookbra.bee.dingtalk.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author tookbra
 * @date 2019/1/10
 * @description
 */
@Slf4j
public class ApacheHttpClient extends HttpClient {

    CloseableHttpClient httpClient =  null;

    @Override
    public void createHttpClient() {
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
    public String post() {
        return null;
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }
}
