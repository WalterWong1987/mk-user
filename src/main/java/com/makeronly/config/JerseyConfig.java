package com.makeronly.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    /**
     * 扫描com.makeronly包，使其识别JAX-RS注解
     */
    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.makeronly");
    }
}
