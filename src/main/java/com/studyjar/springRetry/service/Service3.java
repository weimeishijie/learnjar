package com.studyjar.springRetry.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * Created by mj on 2018/1/3.
 *
 */
public class Service3 {

    // multiplier属性：乘机数，与 delay属性值的乘积数，在乘积的结果上在进行 multiplier属性值的乘机 最终在30秒停止乘积
    // maxAttempts属性：最多执行多少次重连
    // delay属性：为延时多久执行
    @Retryable(value = {RemoteAccessException.class, RuntimeException.class},
            maxAttempts = 10,
            backoff = @Backoff(delay = 1000, multiplier = 2))
    public void service(){
        System.out.println("do some things");
        throw new RemoteAccessException("remote access exception");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("do recover operation");
    }

}
