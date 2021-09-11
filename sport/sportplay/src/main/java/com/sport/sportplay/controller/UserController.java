package com.sport.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.sport.sportplay.bean.QuertInfo;
import com.sport.sportplay.bean.User;
import com.sport.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QuertInfo queryInfo){
        int count = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("count",count);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return  res_string;

    }
}
