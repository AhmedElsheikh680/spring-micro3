package com.spring.zuulgateway;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableZuulProxy
public class SpringZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringZuulGatewayApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;  // Sampler.ALWAYS_SAMPLE, Sampler.NEVER_SAMPLE, Sampler.TRACE_ID_SAMPLE
    }

}
