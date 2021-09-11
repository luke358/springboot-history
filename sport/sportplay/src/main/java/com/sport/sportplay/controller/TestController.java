package com.sport.sportplay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //所有方法返回字符串
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}
