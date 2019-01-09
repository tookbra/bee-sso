package com.tookbra.bee.dingtalk.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tookbra
 * @date 2019/1/9
 * @description
 */
@Data
@ToString
@ConfigurationProperties(prefix = "dingtalk")
public class DingTalkProperties {


    /**
     * 应用的key,唯一标识
     */
    private String appKey;
    /**
     * 应用的密钥
     */
    private String appSecret;

    private HttpConfig httpConfig;

    @Data
    public static class HttpConfig {
        /**
         * 获取链接的超时时间设置
         */
        private int connectionRequestTimeout = 3000;
        /**
         * 建立链接的超时时间
         */
        private int connectionTimeout = 5000;
        /**
         * 空闲链接的超时时间,
         */
        private int idleConnTimeout = 60000;
        /**
         * 每路的最大链接数,默认10
         */
        private int maxConnPerHost = 10;
        /**
         * 最大连接数
         */
        private int maxTotalConn = 50;
        /**
         * 默认NIO的socket超时设置
         */
        private int soTimeout = 5000;
        /**
         * 是否重试
         */
        private boolean retry = false;
    }

}
