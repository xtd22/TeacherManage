package com.example.teachermanage.config;

import com.example.teachermanage.entity.CurrentUser;
import com.example.teachermanage.utils.TokenUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


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
                System.out.println(cookie.getName() + ": " + cookie.getValue());
                if (cookie.getName().equals("Token")){
                    token = cookie.getValue();
                    break;
                }
            }
            if (token == null){
                return false;
            }
            CurrentUser currentUser = tokenUtils.getCurrentUser(token);
            if (currentUser.getUserCode().equals("ss")){
                System.out.println(token);
                System.out.println("*************");
                return true;
            }
        }
        return false;
    }
}
