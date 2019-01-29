package com.tookbra.bee.patch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author tookbra
 * @date 2019/1/25
 * @description
 */
@Configuration
public class ConsulConfig {

    @Autowired
    ConsulAutoServiceRegistration consulAutoServiceRegistration;

    /**
     * fixed spring-framework#21472
     * @param event
     */
    @EventListener
    public void bind(WebServerInitializedEvent event) {
        consulAutoServiceRegistration.bind(event);
    }
}
