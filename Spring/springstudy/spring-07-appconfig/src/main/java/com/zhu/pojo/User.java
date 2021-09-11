package com.zhu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Data
public class User {

    @Value("朱学昌")
    private String name;
}
