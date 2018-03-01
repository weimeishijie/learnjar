package com.studyjar.swagger.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by mj on 2017/12/27.
 *
 */
@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping
    public String hello(){
        return "hello World!";
    }

    @PostMapping
    public void hi(String str){
        System.out.println(str);
    }


}
