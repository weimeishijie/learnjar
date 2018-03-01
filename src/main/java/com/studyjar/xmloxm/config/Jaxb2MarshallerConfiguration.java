package com.studyjar.xmloxm.config;

import com.studyjar.xmloxm.convert.XmlProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mj on 2017/12/29.
 *
 */
@Configuration
public class Jaxb2MarshallerConfiguration {

    @Bean
    public XmlProcessor getHandler(){
        XmlProcessor handler = new XmlProcessor();
        handler.setMarshaller(getCastorMarshaller());
        handler.setUnmarshaller(getCastorMarshaller());
        return handler;
    }

    @Bean
    public Jaxb2Marshaller getCastorMarshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("com.studyjar.xmloxm.domain");
        Map<String, Object> map = new HashMap<>();
        map.put("jaxb.formatted.output", true);
        jaxb2Marshaller.setMarshallerProperties(map);
        return jaxb2Marshaller;
    }


}
