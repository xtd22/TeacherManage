package com.example.teachermanage.service;

import com.example.teachermanage.entity.User;

public interface UserService {

    public User queryUserByCode(String userCode);
}
