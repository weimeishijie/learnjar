package com.studyjar.httpTemplate.test;

import com.studyjar.httpTemplate.template.HttpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mj on 2018/1/3.
 *
 * RestTemplate的getForObject完成get请求、postForObject完成post请求、put对应的完成put请求、delete完成delete请求；还有execute可以执行任何请求的方法，需要你设置RequestMethod来指定当前请求类型。
 * RestTemplate.getForObject(String url, Class responseType, String... urlVariables)
 * 参数url是http请求的地址，参数Class是请求响应返回后的数据的类型，最后一个参数是请求中需要设置的参数。
 * template.getForObject(url + "get/{id}.do", String.class, id);
 * 如上面的参数是{id}，返回的是一个string类型，设置的参数是id。最后执行该方法会返回一个String类型的结果。
 * 下面建立一个测试类，完成对RESTClient的测试。代码如下：
 *
 */
@RestController
@RequestMapping("/http")
public class TestHttpTemplate {

    @Autowired
    private HttpTemplate httpTemplate;

    @GetMapping
    public String httpclient(){
        System.out.println("httpTemplate.getForObject()");
        String str = httpTemplate.getForObject(httpTemplate.getMesApiHttpSchemeHierarchical()+"/oxm", String.class);
        System.out.println("httpTemplate.getForObject(): "+str);
        return str;
    }

    @GetMapping("/oxm")
    public String http(){
//        String str = httpTemplate.getForObject(httpTemplate.getMesApiHttpSchemeHierarchical()+"/oxm?str={a}&xml={b}", String.class, new String[]{"li","wen"});
        String str = httpTemplate.getForObject(httpTemplate.getMesApiHttpSchemeHierarchical()+"/oxm?str=li&xml=wen", String.class);
        System.out.println("httpTemplate.getForObject: "+str);
        return str;
    }

}
