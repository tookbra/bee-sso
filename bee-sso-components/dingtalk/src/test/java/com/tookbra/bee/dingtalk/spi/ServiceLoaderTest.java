package com.tookbra.bee.dingtalk.spi;

import com.tookbra.bee.dingtalk.enums.HttpClientEnum;
import com.tookbra.bee.dingtalk.enums.RepositoryEnum;
import com.tookbra.bee.dingtalk.http.HttpClient;
import com.tookbra.bee.dingtalk.repository.DingTalkRepository;
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
    public void loaderHttpBeanTest() {
        ServiceLoader<HttpClient> sl = ServiceLoader.load(HttpClient.class);
        HttpClient httpClient = StreamSupport.stream(sl.spliterator(), false)
                .filter(f -> Objects.equals(f.getName(), HttpClientEnum.OKHTTP.name()))
                .findFirst().get();
        Assert.assertEquals(httpClient.getName(), HttpClientEnum.OKHTTP.name());

    }

    @Test
    public void loaderApacheHttpBeanTest() {
        ServiceLoader<HttpClient> sl = ServiceLoader.load(HttpClient.class);
        HttpClient httpClient = StreamSupport.stream(sl.spliterator(), false)
                .filter(f -> Objects.equals(f.getName(), HttpClientEnum.APACHE.name()))
                .findFirst().get();
        Assert.assertEquals(httpClient.getName(), HttpClientEnum.APACHE.name());

    }

    @Test
    public void loaderInMemoryRepositoryBeanTest() {
        ServiceLoader<DingTalkRepository> sl = ServiceLoader.load(DingTalkRepository.class);
        DingTalkRepository dingTalkRepository = StreamSupport.stream(sl.spliterator(), false)
                .filter(f -> Objects.equals(f.getName(), RepositoryEnum.IN_MEMORY.name()))
                .findFirst().get();
        Assert.assertEquals(dingTalkRepository.getName(), RepositoryEnum.IN_MEMORY.name());
    }

    @Test
    public void loaderRedisRepositoryBeanTest() {
        ServiceLoader<DingTalkRepository> sl = ServiceLoader.load(DingTalkRepository.class);
        DingTalkRepository dingTalkRepository = StreamSupport.stream(sl.spliterator(), false)
                .filter(f -> Objects.equals(f.getName(), RepositoryEnum.REDIS.name()))
                .findFirst().get();
        Assert.assertEquals(dingTalkRepository.getName(), RepositoryEnum.REDIS.name());
    }
}
