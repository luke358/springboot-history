package com.zhu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("1494135711@qq.com");
        mailMessage.setSubject("小猪，你好");
        mailMessage.setText("谢谢你来陪我");
        mailMessage.setTo("501002557@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2(){
        MimeMessage mailMessage = mailSender.createMimeMessage();

    }

}
