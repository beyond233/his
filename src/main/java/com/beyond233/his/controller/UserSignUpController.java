package com.beyond233.his.controller;

import com.beyond233.his.entity.User;
import com.beyond233.his.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>项目文档: 用户注册</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-03 15:43
 */
@Controller
@RequestMapping("/user")
public class UserSignUpController {
    @Autowired
    UserServiceImpl userService;

    /**
     * 用户注册
     * 成功跳转登录界面
     * 失败返回注册界面
     */
    @PostMapping("/signup")
    public String signUp(User user, HttpServletRequest request) {
        return userService.signUp(user, request) ? "login" : "signup";
    }

    /**
     * 判断用户输入的注册Id是否已经被注册
     * 判断结果实时反馈给前端
     **/
    @ResponseBody
    @PostMapping("/phoneVerify")
    public String signUpIdVerify(@RequestParam("userPhone") String userPhone) {
        return userService.signUpPhoneVerify(userPhone) ? "true" : "false";
    }

    /**
     * 验证密码是否合法
     **/
    @ResponseBody
    @PostMapping("/passwordVerify")
    public String passwordVerify(@RequestParam("userPassword") String password) {
        return userService.signUpPasswordVerify(password) ? "true" : "false";
    }
}
