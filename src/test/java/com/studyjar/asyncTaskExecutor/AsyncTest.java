package com.studyjar.asyncTaskExecutor;

import com.studyjar.asyncTaskExecutor.async.AsyncConfig;
import com.studyjar.asyncTaskExecutor.test.TestService;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by mj on 2017/12/27.
 *
 */
public class AsyncTest extends TestCase {

    private AnnotationConfigApplicationContext context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = new AnnotationConfigApplicationContext(AsyncConfig.class);
    }

    public void testAsyncTask(){
        TestService testService = context.getBean(TestService.class);
        for(int i = 0; i<10; i++){
            testService.AsyncTeskExcutor1(i);
            testService.asyncTaskExcutor2(i);
        }
    }

    //调用返回结果的异步方法示例：
    public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
        System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());
        TestService testService = context.getBean(TestService.class);
        Future<String> future = testService.asyncMethodWithReturnType();
//        while(true){
//            if(future.isDone()){
//                System.out.println("Result from asynchronous process - " + future.get());
//                break;
//            }
//            System.out.println("Continue doing something else. ");
//            Thread.sleep(1000);
//        }
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
        TestService testService = context.getBean(TestService.class);
        for(int i=0; i<10; i++){
            testService.asyncTaskExcutor2(i);
            testService.AsyncTeskExcutor1(i);
        }
//        context.close();
        // 用来获取异步结果
//        Future<String> future = testService.asyncMethodWithReturnType();
//        while(true){
//            if(future.isDone()){
//                System.out.println("Result from asynchronous process - " + future.get());
//                break;
//            }
//            System.out.println("Continue doing something else. ");
//            Thread.sleep(1000);
//        }
    }



}
