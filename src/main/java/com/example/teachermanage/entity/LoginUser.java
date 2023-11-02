package com.example.teachermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    private String userCode;//用户名

    private String userPwd;//密码

//    private String userState;//用户状态
}
