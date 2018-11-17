package com.didispace.feignconsumer.controller;

import com.didispace.feignconsumer.pojo.User;
import com.didispace.feignconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xjx on 2018/11/15.
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("cookie: "+cookie.getName()+"="+cookie.getValue());
        }


        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("</br>");
        sb.append(helloService.hello("DIDI")).append("</br>");
        sb.append(helloService.hello("DIDI", 15)).append("</br>");
        sb.append(helloService.hello(new User("DIDI", 18))).append("</br>");
        return sb.toString();
    }

}
