package com.example.teachermanage.mapper;

import com.example.teachermanage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public User findUserByCode(@Param("userCode") String userCode);
}
