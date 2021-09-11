package com.sport.sportplay.bean;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private  int id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;


}
