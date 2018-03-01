package com.studyjar.springRetry.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * Created by mj on 2018/1/3.
 *
 */
public class Service {

    private int count = 0;

    @Retryable(RuntimeException.class)
    public void service() {
        if (count++ < 2) {
            System.out.println("==============");
            throw new RuntimeException("connection failed");
        }
    }

    public int getCount() {
        return count;
    }

    // 如果使用注解的话,这个recover貌似只能写在本类中,我测试了如果将recover方法写在
    // recoverService中,好像找不到
    @Recover
    public void recover(RuntimeException ex){
        System.out.println(ex.getMessage());
        System.out.println("do recover operation");
    }

}
