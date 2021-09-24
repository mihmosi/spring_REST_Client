package com.mosi.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.mosi.spring.rest")
public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){ // для осуществления запросов
        return  new RestTemplate();
    }
}
