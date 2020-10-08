package com.beyond233.his.controller;

import com.beyond233.his.service.impl.DepartmentServiceImpl;
import com.beyond233.his.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * <p>项目文档: 后台管理控制器</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-09 21:01
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    EmployeeServiceImpl employeeService;
    @Resource
    DepartmentServiceImpl departmentService;

    public void modelData(Model model) {
        model.addAttribute("adminMap", employeeService.adminPageData());
        model.addAttribute("departList", departmentService.findAllDepartIdAndName());
    }

    /**
     * 返回医生管理页面
     **/
    @GetMapping("/doctorManager/page")
    public String toDoctorManagerPage(Model model) {
        modelData(model);
        return "/emp/doctormanager";
    }

    /**
     * 返回添加医生页面
     **/
    @RequestMapping(value = "/doctorAdd/page", method = {RequestMethod.POST, RequestMethod.GET})
    public String toDoctorAddPage(Model model) {
        modelData(model);
        return "/emp/doctor";
    }

    /**
     * 药品管理页面
     **/
    @GetMapping("/drugManager/page")
    public String toDrugManagerPage(Model model) {
        modelData(model);
        return "/emp/drugManager";
    }

    /**
     * 药品添加页面
     **/
    @GetMapping("/drugAdd/page")
    public String toDrugAddPage(Model model) {
        modelData(model);
        return "/emp/drugAdd";
    }

    /**
     * 用户管理页面
     **/
    @GetMapping("/userManager/page")
    public String toUserManagerPage(Model model) {
        modelData(model);
        return "/emp/userManager";
    }

    /**
     * 新闻管理页面
     **/
    @GetMapping("/newsManager/page")
    public String toNewsManagerPage(Model model) {
        modelData(model);
        return "/emp/newsManager";
    }

    /**
     * 新闻添加页面
     **/
    @GetMapping("/newsAdd/page")
    public String toNewsAddPage(Model model) {
        modelData(model);
        return "/emp/newsAdd";
    }


}
