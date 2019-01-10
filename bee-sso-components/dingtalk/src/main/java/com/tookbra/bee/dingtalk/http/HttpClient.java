package com.tookbra.bee.dingtalk.http;


import com.tookbra.bee.dingtalk.config.DingTalkProperties;
import lombok.Data;

/**
 *
 * @author tookbra
 * @date 2019/1/9
 * @description
 */
@Data
public abstract class HttpClient {


    public DingTalkProperties.HttpConfig httpConfig;

    /**
     *
     */
    public abstract void createHttpClient();

    public abstract String post();

    public abstract String get();

    public abstract String name();

}
