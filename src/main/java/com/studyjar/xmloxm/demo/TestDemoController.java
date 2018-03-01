package com.studyjar.xmloxm.demo;

import com.studyjar.xmloxm.convert.XmlProcessor;
import com.studyjar.xmloxm.domain.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by mj on 2018/1/2.
 *
 */
@RestController
@RequestMapping("/oxm")
public class TestDemoController {

//    @Autowired
//    @Qualifier("testQualifier")// 指定传进来的 bean
//    private TestQualifier testQualifier;

    @Autowired
    private XmlProcessor xmlProcessor;

    @GetMapping
    public String test(String str, String xml){
        try {
            System.out.println("str: " + str + " xml: " + xml);
            return xmlProcessor.objectToXML(new Point(str, xml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @GetMapping
//    public String test(){
//        try {
//            return xmlProcessor.objectToXML(new Point("li", "wen"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
