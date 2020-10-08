package com.beyond233.his.controller;

import com.beyond233.his.service.AccountService;
import com.beyond233.his.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @date 2020-02-17 18:12
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Resource
    UserServiceImpl accountService;

    @GetMapping("/login/page")
    public String toUserLoginPage(HttpServletRequest request) {
        //获取请求头中的referer信息
        String referer = request.getHeader("referer");
        if (referer != null) {
            request.getSession().setAttribute("refererInfo", referer);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        int verify = accountService.loginVerify(phone, password, request);
        if (verify == 1) {
            try {
                String referer = (String) request.getSession().getAttribute("refererInfo");
                //如何是重新登录，则重定向到index页面
                if (referer.contains("exit") || referer.contains("login") || referer.contains("reset") || referer.contains("signup")) {
                    return "redirect:/index";
                } else {
                    //登录成功：重定向到之前的页面
                    response.sendRedirect(referer);
                }
            } catch (Exception e) {
                return "index";
            }
            return "index";
        } else {
            //登录失败
            return "login";
        }

    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        //移除已登录的用户
        request.getSession().removeAttribute("login");
        return "login";
    }


}
