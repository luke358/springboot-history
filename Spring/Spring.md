## 1、Spring

### 1.1、简介

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

```

### 1.2、优点

+ Spring是一个开源的免费的框架（容器)
+ Spring是一个轻量级的、非入侵式的框架
+ 控制反转（IOC），面向切面编程（AOP)
+ 支持事务的处理，对框架整合的支持

**总结一句话: Spring就是一个轻量级的控制反转(I0C) 和面向切面编程(AOP) 的框架!**

### 1.3、组成

![1593664682741](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\1593664682741.png)



### 1.4拓展

在Spring的官网有这个介绍:现代化的Java开发!说白就是基于Spring的开发!

![1593664788273](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\1593664788273.png)

+ springboot
  + 一个快速开发的脚手架
  + 基于Spring boot可以快速的开发单个微服务
  + 约定大于配置
+ Spring Colud
  + SpringColud是基于SpringBoot实现的



因为现在大多数公司都在使用SpringBoot进行快速开发，学习SpringBoot的前提， 需要完全掌握Spring及SpringMVC!



弊端：发展太久之后违背了原来的理念！ 配置十分繁琐，人称:"配置地狱"





## 2、IOC理论推导

1. UserDao接口
2. UserDaolmpl实现类
3. UserService业务接口
4. UserServicelmpl业务实现类



在我们之前的业务中,用户的需求可能会影响我们原来的代码，我们需要根据用户的需求去修改原代码!如果程序代码量十分大，修改-次的成本代价十分昂贵!



我们使用一-个Set接口实现，已经发生了革命性得变化

```java
private UserDao userDao;

//利用set进行动态实现值得注入
public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
}
```



+ 之前，程序是主动创建对象!控制权在程序猿手上!
+ 使用了set注入后，程序不再具有主动性，而是变成了被动的接受对象!



### IOC本质.

控制反转IoC(Inversion of Control),是- -种设计思想，DI(依赖注入)是实现IoC的一种方法，也有人认为DI只是
loC的另一种说法。 没有IoC的程序中,我们使用面向对象编程,对象的创建与对象间的依赖关系完全硬编码在程序
中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是:获得依赖
对象的方式反转了。



采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体,
Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**控制反转是一种通过描述(XML或注解)并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反
转的是IoC容器，其实现方法是依赖注入(Dependency Injection,DI)。**



### 3、hello spring



## 4、注解

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           https://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```



@Autowired自动注入bean，

当存xml文件存在多个cat时，需要使用Qualifier指定使用者的id

```java
@Data
public class People {

    @Autowired
    @Qualifier(value = "cat")
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;
}
```



@Resource,t通过name指定绑定唯一bean

```java
@Data
public class People {

    @Resource(name = "cat1")
    private Cat cat;

    @Autowired
    private Dog dog;
    private String name;
}
```

## 5、使用注解开发

spring4之后，使用注解开发需要导入aop



使用注解需要导入context约束，增加注解的支持!

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           https://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```





1.bean

2.属性如何注入

```java
@Component
@Data
public class User {

    @Value("朱学昌")
    public String name;
}
等价于
<bean id="user" class="com.zhu.pojo.User">
    <property name="name" value="朱学昌"/>
</bean>
```



3.衍生的注解

@Component有几个衍生注解，我们在web开发中，会按照mvc三层架构分层!

- dao	【@Repository】

- dao【@Repository】

- controller   【@Controller】

  这四个注解功能都是一样的， 都是代表将某个类注册到Spring中,装配Bean

4.自动配置

```xml
- @Autowired: 自动装配通过byType,然后byName
  - 如果Autowired不能唯一自动装配属性需要通过@Qualifier(value="xxx")
- @Nullable     字段标记了这个注解，说明这个字段可以为null
- @Resource   自动装配通过名字，类型
- @Commponent   组件，放在类上，说明这个类被Spring管理了，就是Bean
```

6.小结

xml与注解:

- xml更加万能，适用于任何场合!维护简单方便
- 注解不是自己类使用不了，维护相对复杂!

xml与注解最佳实践:

- xml用来管理bean;
- 注解只负责完成属性的注入; .
- 我们在使用的过程中，只需要注意-一个问题:必须让注解生效，就需要开启注解的支持

```xml
<!--    指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.zhu"/>
    <context:annotation-config/>
```



## 注解说明

- @Autowired: 自动装配通过byType,然后byName
  - 如果Autowired不能唯一自动装配属性需要通过@Qualifier(value="xxx")
- @Nullable     字段标记了这个注解，说明这个字段可以为null
- @Resource   自动装配通过名字，类型
- @Commponent   组件，放在类上，说明这个类被Spring管理了，就是Bean



## 6、使用Java的方式配置Spring

我们现在要完全不使用Spring的xml配置了，全权交给Java来做.
JavaConfig是Spring的一个子项目,在Spring4之后，它成为了核心功能



## 7、AOP

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```



方式一：使用spring的接口

```xml
<!-- 注册bean-->
<bean id="userService" class="com.zhu.service.UserServiceImpl"></bean>
<bean id="log" class="com.zhu.log.log"></bean>
<bean id="afterLog" class="com.zhu.log.AfterLog"></bean>

<!--    方式一：使用原生Spring API接口-->
<!--    配置aop-->
<aop:config>
    <!--切入点 expression:表达式。 execution(要执行的位置!)-->
    <aop:pointcut id="pointcut" expression="execution(* com.zhu.service.UserServiceImpl.*(..))"/>

    <!--        执行环绕增加-->
    <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
    <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
</aop:config>
</beans>
```

方式二：自定义来实现AOP

```xml
<bean id="diy" class="com.zhu.diy.DiyPointCut"/>

<aop:config>
    <!--        自定义切面-->
    <aop:aspect ref="diy">
        <!--            切入点-->
        <aop:pointcut id="point" expression="execution(* com.zhu.service.UserServiceImpl.*(..))"/>
        <!--            通知-->
        <aop:before method="before" pointcut-ref="point"/>
        <aop:after method="after" pointcut-ref="point"/>
    </aop:aspect>
</aop:config>
```

方式三：使用注解实现



## 8、回忆mybatis

1.编写实体类

2.编写核心配置文件

3.编写接口

4.编写Mapper.xml

5.测试



## 9、mybatis-spring

1.编写数据源

2.sqlSessionFactory

3.sqlSessionTemplate

4.需要给接口加实现类

5.将自己写的实现类，注入到mybatis中

6.测试