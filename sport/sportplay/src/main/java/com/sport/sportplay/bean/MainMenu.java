package com.sport.sportplay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu> slist;
}
