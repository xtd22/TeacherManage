package com.example.teachermanage;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.teachermanage.mapper")
@SpringBootApplication
@ComponentScan("com")
public class TeacherManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherManageApplication.class, args);
    }

}
