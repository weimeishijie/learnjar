package com.studyjar.asyncTaskExecutor.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by mj on 2017/12/27.
 *
 */
@Service
public class TestService {

    // 没有返回值
    @Async
    public void AsyncTeskExcutor1(Integer i){
        System.out.println("异步任务执行一："+i);
        System.out.println(Thread.currentThread().getName());
    }

    // 没有返回值
    @Async
    public void asyncTaskExcutor2(Integer i){
        System.out.println("异步任务执行二："+i);
        System.out.println(Thread.currentThread().getName());
//        throw new RuntimeException();
    }

    // 没有返回值
    @Async
    public void AsyncTeskExcutor3(String str){
        System.out.println("异步任务执行一："+str);
        System.out.println(Thread.currentThread().getName());
    }


    // 基于@Async返回值的调用：
    // 可以发现，返回的数据类型为Future类型，其为一个接口。具体的结果类型为AsyncResult,这个是需要注意的地方。
    @Async
    public Future<String> asyncMethodWithReturnType(){
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
