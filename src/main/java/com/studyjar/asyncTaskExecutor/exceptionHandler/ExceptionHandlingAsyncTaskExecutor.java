package com.studyjar.asyncTaskExecutor.exceptionHandler;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by mj on 2017/12/27.
 *
 * 异步线程异常处理机制
 *
 *1 <task:annotation-driven executor="exceptionHandlingTaskExecutor" scheduler="defaultTaskScheduler" />
 *2 <bean id="exceptionHandlingTaskExecutor" class="nl.jborsje.blog.examples.ExceptionHandlingAsyncTaskExecutor">
 *3     <constructor-arg ref="defaultTaskExecutor" />
 *4 </bean>
 *5 <task:executor id="defaultTaskExecutor" pool-size="5" />
 *6 <task:scheduler id="defaultTaskScheduler" pool-size="1" />
 */
public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor, InitializingBean, DisposableBean {

    private final AsyncTaskExecutor executor;

    public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    // 创建一个包装的 Runnable
    private Runnable createWrappedRunnable(final Runnable task){
        return () -> {
            try {
                task.run();
            } catch (Exception e){
                handle(e);
            }
        };
    }

    // 创建一个包装的 Callable
    private Callable createCallable(final Callable task){
        return () -> {
            try {
                return task.call();
            } catch (Exception e) {
                handle(e);
                throw e;
            }
        };
    }

    private void handle(Exception e){
        System.out.println("Error during @Async execution: " + e);
    }


    @Override
    public void destroy() throws Exception {
        if(executor instanceof DisposableBean){
            DisposableBean bean = (DisposableBean)executor;
            bean.destroy();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(executor instanceof InitializingBean){
            InitializingBean bean = (InitializingBean)executor;
            bean.afterPropertiesSet();
        }
    }

    // 用独立的线程包装起来
    @Override
    public void execute(Runnable task, long startTimeout) {
        executor.execute(createWrappedRunnable(task), startTimeout);
    }

    // 用独立的线程包装起来
    @Override
    public Future<?> submit(Runnable task) {
        return executor.submit(createWrappedRunnable(task));
    }

    // 用独立的线程包装起来
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(createCallable(task));
    }

    // 用独立的线程包装起来
    @Override
    public void execute(Runnable task) {
        executor.execute(createWrappedRunnable(task));
    }
}
