## springboot 集成 swagger

1.导入jar包

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.4.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.4.0</version>
</dependency>
```

2.编写一个接口

3.配置Swagger  ==》 Config

```java
@Configuration
@EnableSwagger2 //开启swagger
public class SwaggerConfig {   
}
```

5.测试运行

