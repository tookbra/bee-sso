package com.tookbra.bee.dingtalk.http;


import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author tookbra
 * @date 2019/1/10
 * @description
 */
@Slf4j
public class OkHttpClient extends HttpClient {


    okhttp3.OkHttpClient okHttpClient = null;

    @Override
    public void createHttpClient() {
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
