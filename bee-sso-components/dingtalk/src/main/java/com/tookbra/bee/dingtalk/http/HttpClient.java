package com.tookbra.bee.dingtalk.http;


import java.io.IOException;

/**
 *
 * @author tookbra
 * @date 2019/1/9
 * @description
 */
public interface HttpClient {


    /**
     * 创建http
     */
    void createHttpClient();

    /**
     * post请求
     * @param url
     * @param data
     * @return
     * @throws IOException
     */
    String post(String url, String data) throws IOException;

    /**
     * get请求
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    String get(String url, String param) throws IOException;

    /**
     * http客户端名称
     * @return
     */
    String getName();

}
