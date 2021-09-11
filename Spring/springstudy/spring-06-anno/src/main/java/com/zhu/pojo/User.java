package com.zhu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="xxxxxx"/>

@Component
@Data
@Scope("prototype")
public class User {

    @Value("朱学昌")
    public String name;
}
