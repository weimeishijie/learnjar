package com.studyjar.scheduling;

import com.studyjar.rabbitmq.test.MessagePushService;
import com.studyjar.xmloxm.convert.XmlProcessor;
import com.studyjar.xmloxm.domain.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;


/**
 * Created by mj on 2017/12/27.
 *
 */
@RestController
@EnableScheduling
@RequestMapping("demo")
public class TestSchedulingController {

    @Autowired
    private XmlProcessor xmlProcessor;

    @Autowired
    private MessagePushService messagePushService;

    @GetMapping
    public void hello(){
        System.out.println("测试不同的api");
    }

//    @Scheduled(cron = "0/3 * * * * ?")
//    private void testScheduling(){
//        String message = "123456789";
//        try {
//            messagePushService.sendMessage("message", message.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

//    @Scheduled(cron = "0/3 * * * * ?")
//    private void testScheduling(){
////        System.out.println("我是定时任务");
//
//        try {
//            String string = xmlProcessor.objectToXML(new Point("贺","慧"));
//            System.out.println(string);
//
//            Object object = xmlProcessor.xmlToObject(string.toString());
//            System.out.println(object);
//            System.out.println();
//            System.out.println();
//            System.out.println();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
