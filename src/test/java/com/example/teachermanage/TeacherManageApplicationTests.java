package com.example.teachermanage;

import com.example.teachermanage.entity.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherManageApplicationTests {

    @Test
    void contextLoads() {
        LoginUser loginUser = new LoginUser();
        System.out.println(loginUser);
    }

}
