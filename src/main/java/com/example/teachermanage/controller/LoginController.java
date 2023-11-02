package com.example.teachermanage.controller;

import com.example.teachermanage.entity.CurrentUser;
import com.example.teachermanage.entity.LoginUser;
import com.example.teachermanage.entity.Result;
import com.example.teachermanage.entity.User;
import com.example.teachermanage.service.UserService;
import com.example.teachermanage.utils.Constants;
import com.example.teachermanage.utils.DigestUtil;
import com.example.teachermanage.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtils tokenUtils;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public Result login(@RequestParam("userCode") String userCode, @RequestParam("userPwd") String userPwd){
    public Result login(@RequestBody LoginUser loginUser){
//        System.out.println(userCode);
//        System.out.println(userPwd);
//        LoginUser loginUser = new LoginUser(userCode,userPwd);
        User user = userService.queryUserByCode(loginUser.getUserCode());
//        System.out.println(user.getUserCode());
//        System.out.println("++++++++++++++++++++++++++++");
//        System.out.println(user.getUserPwd());
        if (user != null){//账号存在
            //进行md5加密
            String userPwd = DigestUtil.hmacSign(loginUser.getUserPwd());
            System.out.println(userPwd);
            if (userPwd.equals(user.getUserPwd())){//密码正确
                //生成jwt Token并存储到redis
                CurrentUser currentUser =
                        new CurrentUser(user.getUserId(), user.getUserCode(), user.getUserName());
                String token = tokenUtils.loginSign(currentUser, userPwd);
                //向客户端响应jwt Token
                return Result.ok("登陆成功！",token);
            }else {//密码错误
                return Result.err(Result.CODE_ERR_BUSINESS,"密码错误");
            }
        }else {//账号不存在
            return Result.err(Result.CODE_ERR_BUSINESS,"账号不存在！");
        }

    }


}
