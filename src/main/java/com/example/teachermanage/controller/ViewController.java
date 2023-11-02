package com.example.teachermanage.controller;

import com.example.teachermanage.entity.CurrentUser;
import com.example.teachermanage.entity.Result;
import com.example.teachermanage.exception.BusinessException;
import com.example.teachermanage.exception.TokenIsEmptyException;
import com.example.teachermanage.utils.Constants;
import com.example.teachermanage.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private TokenUtils tokenUtils;
    @RequestMapping(value = "/index")
    public Result index(@RequestHeader(Constants.HEADER_TOKEN_NAME) String token){
        try {
            System.out.println("============index===============");
            System.out.println(token);
            CurrentUser currentUser = tokenUtils.getCurrentUser(token);
            return Result.ok("主页",currentUser);
        }catch (TokenIsEmptyException tokenIsEmptyException){
            return Result.err(1,tokenIsEmptyException.getMessage());
        }
    }
}
