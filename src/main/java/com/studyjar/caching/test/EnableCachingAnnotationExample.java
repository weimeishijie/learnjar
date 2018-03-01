package com.studyjar.caching.test;

import com.studyjar.caching.config.CacheConfig;
import com.studyjar.caching.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mj on 2018/1/5.
 *
 */
public class EnableCachingAnnotationExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CacheConfig.class);
        context.refresh();
        Book book = context.getBean(Book.class);
        // calling getBook method first time.
        System.out.println(book.getBook(1));
        // calling getBook method second time. This time, method will not
        // execute.
        System.out.println(book.getBook(1));
        // calling getBook method third time with different value.
        System.out.println(book.getBook(2));
        context.close();
    }


}
