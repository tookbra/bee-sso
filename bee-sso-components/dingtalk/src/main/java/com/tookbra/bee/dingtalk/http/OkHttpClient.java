package com.tookbra.bee.dingtalk.http;


import com.tookbra.bee.dingtalk.enums.HttpClientEnum;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.client.HttpResponseException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
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
    public String post(String url, String data) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("json"), data);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = okHttpClient.newCall(request).execute();
        return this.filterResponse(response);
    }

    @Override
    public String get(String url, String param) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        return this.filterResponse(response);
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
