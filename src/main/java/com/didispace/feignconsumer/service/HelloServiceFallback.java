package com.didispace.feignconsumer.service;

import com.didispace.feignconsumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Created by xjx on 2018/11/16.
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
