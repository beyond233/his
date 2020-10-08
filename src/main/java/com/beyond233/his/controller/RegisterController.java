package com.beyond233.his.controller;

import com.beyond233.his.entity.User;
import com.beyond233.his.service.impl.DepartmentServiceImpl;
import com.beyond233.his.service.impl.RegisterServiceImpl;
import com.beyond233.his.vo.ExpertRegisterRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>项目文档: 挂号服务控制器</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-08 13:13
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Resource
    DepartmentServiceImpl departmentService;
    @Resource
    RegisterServiceImpl registerService;

    @GetMapping("/page")
    public String registerPage(Model model) {
        //查询所有的科室类型以及该类型下的所有科室
        model.addAttribute("departmentList", departmentService.findDepartmentTypeAndName());
        return "register";
    }

    /**
     * 通过科室id查询其对应的排班信息
     **/
    @GetMapping("/info/{id}")
    public String registerInfoList(Model model, @PathVariable int id) {
        model.addAttribute("registerList", registerService.findRegisterInfo(id));
        model.addAttribute("department", departmentService.findDepartmentById(id));
        return "registerdepart";
    }

    /**
     * 实现患者预约挂号
     **/
    @ResponseBody
    @PostMapping("/{registerId}")
    public String userRegister(@PathVariable int registerId, HttpServletRequest request) {
        //先判断用户是否登录
        User user = (User) request.getSession().getAttribute("login");
        //若已用户登录，则进行预约挂号操作
        if (user != null) {
            registerService.userRegister(user.getUserId(), registerId);
            return "success";
        } else { //未登录则反馈前端提示用户需先登录再进行挂号
            return "login";
        }
    }

    /**
     * 患者取消预约挂号
     **/
    @ResponseBody
    @DeleteMapping("/{registerId}")
    public String cancelRegister(@PathVariable int registerId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("login");
        registerService.userRegisterCancel(user.getUserId(), registerId);
        return "userspace";
    }

    /**
     * 查询专家出诊信息
     **/
    @ResponseBody
    @GetMapping("/expertRegister/data")
    public Map<String, Object> returnAllExpertRegisterInfo() {
        Map<String, Object> map = new HashMap<>(100);
        List<ExpertRegisterRecord> registerRecordList = registerService.findAllExpertRegisterInfo();
        map.put("data", registerRecordList);
        map.put("code", 0);
        map.put("message", "");
        map.put("total", registerRecordList.size());
        return map;
    }


}
