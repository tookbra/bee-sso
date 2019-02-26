package com.tookbra.bee.dingtalk.api;

import com.tookbra.bee.dingtalk.api.DingTalkService;
import com.tookbra.bee.dingtalk.api.DingTalkServiceImpl;
import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import com.tookbra.bee.dingtalk.http.ApacheHttpClient;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.http.OkHttpClient;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
import com.tookbra.bee.dingtalk.repository.InMemoryRepository;
import org.junit.Before;
import org.junit.Test;

/**
 * @author tookbra
 * @date 2019/1/17
 * @description
 */
public class DingTalkServiceTest {

    private DingTalkService dingTalkService;

    @Before
    public void init() {
        DingTalkProperties dingTalkProperties = new DingTalkProperties();
        dingTalkProperties.setAppKey("dingnczyn00s8nlvncvc");
        dingTalkProperties.setAppSecret("vjOO9s2Mfw-3T9m7LLyIKkW2N1wCjicbBL0VC6soBPBu4n6z2Lk3dLYZBDAZCgG3");
        dingTalkProperties.setAgentId(193262077);
        DingTalkProperties.HttpConfig httpConfig = new DingTalkProperties.HttpConfig();
        dingTalkProperties.setHttpConfig(httpConfig);
        DingTalkRepository dingTalkRepository = new InMemoryRepository();

        HttpClient httpClient = new OkHttpClient();
        dingTalkService = new DingTalkServiceImpl(httpClient, dingTalkProperties, dingTalkRepository);

    }

    @Test
    public void getAccessTokenTest() {
        dingTalkService.getAccessToken(false);
    }

    public DingTalkService getDingTalkService() {
        return dingTalkService;
    }
}
