package com.example.teachermanage.entity;

import lombok.Data;

@Data
public class User {

    private int userId;//用户id

    private String userCode;//账号

    private String userName;//用户名

    private String userPwd;//用户密码

    private String role;//用户角色
}
