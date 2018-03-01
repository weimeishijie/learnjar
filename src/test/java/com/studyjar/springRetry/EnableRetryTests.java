package com.studyjar.springRetry;

import com.studyjar.springRetry.config.RetryConfig;
import com.studyjar.springRetry.service.Service;
import com.studyjar.springRetry.service.Service1;
import com.studyjar.springRetry.service.Service3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mj on 2018/1/3.
 *
 */
public class EnableRetryTests {

    @Test
    public void vanilla(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                RetryConfig.class);
        Service service = context.getBean(Service.class);
//        assertTrue(AopUtils.isAopProxy(service));
        service.service();
        assertEquals(3, service.getCount());
        context.close();
    }

    @Test
    public void service1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RetryConfig.class);
        Service1 service1 = context.getBean(Service1.class);
        service1.service();
        context.close();
    }

    @Test
    public void service3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RetryConfig.class);
        Service3 service3 = context.getBean(Service3.class);
        service3.service();
        context.close();
    }

}
