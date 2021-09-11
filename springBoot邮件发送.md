## 邮件发送



1.导入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

2.配置

```yaml
spring:
  mail:
    host: smtp.qq.com
    username: 1494135711@qq.com
    password: btbbzvuhbjtyhbbi
    properties:
      mail.smtp.ssl.enable: true

```





3.测试

```java
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
```

