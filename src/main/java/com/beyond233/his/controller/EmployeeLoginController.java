package com.beyond233.his.controller;

import com.beyond233.his.entity.Employee;
import com.beyond233.his.service.impl.EmployeeServiceImpl;
import com.beyond233.his.token.EmpPhonePasswordToken;
import com.beyond233.his.vo.LoginEmployeeVO;
import com.beyond233.his.vo.LoginUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>项目文档: 员工登录控制器</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-09 14:41
 */
@Controller
@RequestMapping("/emp")
public class EmployeeLoginController {
    @Resource
    EmployeeServiceImpl employeeService;

    /**
     * 员工登录验证
     **/
    @PostMapping("/login")
    public String empLoginVerify(Employee employee, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前登录主体
        Subject subject = SecurityUtils.getSubject();
        //创建令牌对象
        EmpPhonePasswordToken token = new EmpPhonePasswordToken(employee.getEmpPhone(), employee.getEmpPassword());
        try {
            //执行登录
            subject.login(token);
            //获取当前登录对象
            LoginEmployeeVO loginEmployeeVO = (LoginEmployeeVO) subject.getPrincipal();
            //将登录对象保存到session中
            request.getSession().setAttribute("empLogin", loginEmployeeVO.getEmployee());
            //返回页面
            return "redirect:/department/manager/page";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "redirect:/emp/emplogin.html";

    }

    @GetMapping("/exit")
    public String exit(HttpServletRequest request) {
        //移除已登录的用户
        request.getSession().removeAttribute("empLogin");
        return "emp/emplogin";
    }

    @RequestMapping(value = "/adminPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String adminPage(Model model) {
        model.addAttribute("adminMap", employeeService.adminPageData());
        return "/emp/admin";
    }

    @PostMapping("/doctorPage")
    public String doctorPage(Model model) {
        return "/emp/doctor";
    }


}
