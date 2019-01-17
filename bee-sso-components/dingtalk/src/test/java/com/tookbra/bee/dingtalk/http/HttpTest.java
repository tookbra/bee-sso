package com.tookbra.bee.dingtalk.http;

import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import org.junit.Test;

import java.io.IOException;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public class HttpTest {

    @Test
    public void okHttpCreateTest() throws IOException {
        DingTalkProperties.HttpConfig httpConfig = new DingTalkProperties.HttpConfig();
        HttpClient httpClient = new ApacheHttpClient();
        ((ApacheHttpClient) httpClient).setHttpConfig(httpConfig);
        httpClient.init(httpConfig, null);
        httpClient.get("http://www.baidu.com",null);
    }
}
