package com.tookbra.bee.dingtalk.http;


import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @author tookbra
 * @date 2019/1/9
 * @description
 */
public interface HttpClient {

    /**
     *
     * @param httpConfig
     * @param dingTalkRepository
     */
    void init(DingTalkProperties.HttpConfig httpConfig, DingTalkRepository dingTalkRepository);

    /**
     * post请求
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    String post(String url, Map<String, Object> param) throws IOException;

    /**
     * get请求
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    String get(String url, Map<String, Object> param) throws IOException;

    /**
     * http客户端名称
     * @return
     */
    String getName();

}
