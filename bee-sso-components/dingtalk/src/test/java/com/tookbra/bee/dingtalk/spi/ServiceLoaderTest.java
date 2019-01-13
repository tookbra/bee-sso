package com.tookbra.bee.dingtalk.spi;

import com.tookbra.bee.dingtalk.enums.HttpClientEnum;
import com.tookbra.bee.dingtalk.http.HttpClient;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @author tookbra
 * @date 2019/1/11
 * @description
 */
public class ServiceLoaderTest {

    @Test
    public void loaderBeanTest() {
        ServiceLoader<HttpClient> sl = ServiceLoader.load(HttpClient.class);
        HttpClient httpClient = StreamSupport.stream(sl.spliterator(), false)
                .filter(f -> Objects.equals(f.getName(), HttpClientEnum.OKHTTP.name()))
                .findFirst().get();
        Assert.assertEquals(httpClient.getName(), HttpClientEnum.OKHTTP.name());

    }
}
