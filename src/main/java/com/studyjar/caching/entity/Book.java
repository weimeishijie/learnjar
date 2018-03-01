package com.studyjar.caching.entity;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created by mj on 2018/1/5.
 *
 */
public class Book {

    @Cacheable(value = "sampleCache")
    public String getBook(int id){
        System.out.println("Method executed...");
        if(id == 1){
            return "book 1";
        } else {
            return "book 2";
        }
    }

}
