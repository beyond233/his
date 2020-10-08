package com.beyond233.his.controller;

import com.beyond233.his.exception.MyPageNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-19 17:20
 */
@Controller
@RequestMapping("/exception")
public class ExceptionTestController {
    @RequestMapping("/page")
    public void pageNotExist() {
        System.out.println("page not exist");
        throw new MyPageNotExistException();
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
