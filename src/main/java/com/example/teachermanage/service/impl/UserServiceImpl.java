package com.example.teachermanage.service.impl;

import com.example.teachermanage.entity.User;
import com.example.teachermanage.mapper.UserMapper;
import com.example.teachermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByCode(String userCode) {
        return userMapper.findUserByCode(userCode);
    }
}
