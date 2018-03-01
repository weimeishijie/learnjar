//package com.studyjar.swagger.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * Created by mj on 2017/12/27.
// *
// * Configuration Without Spring Boot:
// * Without Spring Boot, you don’t have the luxury of auto-configuration of your resource handlers.
// * Swagger UI adds a set of resources which you must configure as part of a class that extends WebMvcConfigurerAdapter,
// * and is annotated with @EnableWebMvc.
// *
// */
//@Configuration
//@EnableWebMvc
//public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars");
//    }
//}
