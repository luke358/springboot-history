package com.zhu.config;

import com.zhu.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ZhuConfig {

    @Bean
    public User user(){
        return new User();
    }
}
