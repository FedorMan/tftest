package com.tftest.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfig {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}