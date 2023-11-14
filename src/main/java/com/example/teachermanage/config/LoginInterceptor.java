package com.example.teachermanage.config;

import com.example.teachermanage.entity.CurrentUser;
import com.example.teachermanage.utils.TokenUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器-------");
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
//                System.out.println(cookie.getName() + ": " + cookie.getValue());
                if (cookie.getName().equals("Token")){
                    token = cookie.getValue();
                    break;
                }
            }
            if (token == null){
                redirectToLoginPage(response);
                return false;
            }
            CurrentUser currentUser = tokenUtils.getCurrentUser(token);
            if (currentUser.getUserCode().equals("ss")){
//                System.out.println(token);
//                System.out.println("*************");
                return true;
            }
        }
        redirectToLoginPage(response);
        return false;
    }

    private void redirectToLoginPage(HttpServletResponse response) throws IOException {
        // 这里的 "/login" 是你登录页面的 URL，根据你的实际情况修改
        response.sendRedirect("/login.html");
    }
}
