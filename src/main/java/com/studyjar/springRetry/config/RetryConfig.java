package com.studyjar.springRetry.config;

import com.studyjar.springRetry.service.Service;
import com.studyjar.springRetry.service.Service1;
import com.studyjar.springRetry.service.Service3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by mj on 2018/1/3.
 *
 * <dependency>
 * <groupId>org.springframework.retry</groupId>
 * <artifactId>spring-retry</artifactId>
 * <version>1.2.0.RELEASE</version>
 * </dependency>
 *
 */
@Configuration
@EnableRetry
public class RetryConfig {

    @Bean
    public Service service(){
        return new Service();
    }

    @Bean
    public Service1 service1(){
        return new Service1();
    }

    @Bean
    public Service3 service3(){
        return new Service3();
    }



}
