package com.studyjar.springRetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * Created by mj on 2018/1/3.
 *
 */
public class Service1 {

    // value属性：多久自行一次
    @Retryable(value = {RemoteAccessException.class, RuntimeException.class},
            maxAttempts = 5,
            backoff = @Backoff(value = 2000))
    public void service(){
        System.out.println("do some things");
        throw new RemoteAccessException("remote access exception");
    }

    // 如果使用注解的话,这个 recover 貌似只能写在本类中,如果将 recover 方法写在
    // Service3中,好像找不到
    @Recover
    public void recover1(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("do recover operation1");
    }

    @Recover
    public void recover2(RuntimeException e) {
        System.out.println(e.getMessage());
        System.out.println("do recover operation2");
    }

    @Recover
    public void recover3(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("do recover operation3");
    }

}
