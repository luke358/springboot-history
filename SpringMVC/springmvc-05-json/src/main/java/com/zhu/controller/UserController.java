package com.zhu.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhu.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/j1")
//    @ResponseBody //不会走视图解析器，直接返回一个字符串
    public String json1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        User user = new User("zxc",3,"男");

        String str = mapper.writeValueAsString(user);


        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        User user1 = new User("zxc1",3,"男");
        User user2 = new User("zxc2",3,"男");
        User user3 = new User("zxc3",3,"男");
        User user4 = new User("zxc4",3,"男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);
        return str;
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();


        List<User> userList = new ArrayList<User>();
        User user1 = new User("zxc1",3,"男");
        User user2 = new User("zxc2",3,"男");
        User user3 = new User("zxc3",3,"男");
        User user4 = new User("zxc4",3,"男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        return JSON.toJSONString(userList);
    }


}
