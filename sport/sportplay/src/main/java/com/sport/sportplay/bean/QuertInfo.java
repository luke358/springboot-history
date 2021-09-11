package com.sport.sportplay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuertInfo {
    private String query;
    private int pageNum = 1;
    private int pageSize = 1;
}
