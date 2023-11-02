package com.example.teachermanage;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.teachermanage.mapper")
@SpringBootApplication
public class TeacherManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherManageApplication.class, args);
    }

}
