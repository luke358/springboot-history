package com.sport.sportplay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//分支
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubMenu {
    private int id;
    private String title;
    private String path;
}
