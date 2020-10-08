package com.beyond233.his.controller;

import com.beyond233.his.entity.Employee;
import com.beyond233.his.service.impl.DepartmentServiceImpl;
import com.beyond233.his.service.impl.EmployeeServiceImpl;
import com.beyond233.his.service.impl.RegisterServiceImpl;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>项目文档: 员工控制器</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-07 22:57
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    EmployeeServiceImpl employeeService;
    @Resource
    DepartmentServiceImpl departmentService;
    @Resource
    RegisterServiceImpl registerService;

    @GetMapping("/doctor/page")
    public String toDoctorIntroPage(Model model) {
        model.addAttribute("doctorList", employeeService.findDoctorsByPageNumAndSize(1, 8));
        model.addAttribute("departTypeList", departmentService.findAllDepartTypes());
        return "doctorMain";
    }

    /**
     * 分页查询医生，返回json数据
     **/
    @ResponseBody
    @GetMapping("/doctor/{pageNum}/{pageSize}")
    public List<Employee> returnDoctorsByPageNumAndSize(@PathVariable int pageNum, @PathVariable int pageSize) {
        return employeeService.findDoctorsByPageNumAndSize(pageNum, pageSize);
    }

    /**
     * 返回所有医生信息
     **/
    @ResponseBody
    @GetMapping("/doctor/all/data")
    public Map<String, Object> returnAllDoctorsInfoMap() {
        Map<String, Object> map = new HashMap<>(100);
        List<Employee> employeeList = employeeService.findAllDoctors();
        map.put("code", 0);
        map.put("message", "");
        map.put("total", employeeList.size());
        map.put("data", employeeList);
        return map;
    }

    /**
     * 分页查询医生信息
     **/
    @ResponseBody
    @GetMapping("/doctor/limit")
    public Map<String, Object> returnLimitDoctorsInfoMap(int page, int limit) {
        Map<String, Object> map = new HashMap<>(100);
        int count = employeeService.findAllDoctors().size();
        PageHelper.startPage(page, limit);
        List<Employee> employeeList = employeeService.findAllDoctors();
        map.put("code", 0);
        map.put("message", "");
        map.put("count", count);
        map.put("data", employeeList);
        return map;
    }

    /**
     * 查询对应科室de医生信息，返回json
     **/
    @ResponseBody
    @GetMapping("/doctor/departId/data")

    public List<Employee> returnDoctorInDepartType(@RequestParam("departId") Integer id) {
        return employeeService.findAllDoctorsByDepartmentId(id);
    }

    /**
     * 通过id查询医生信息，返回json
     **/
    @ResponseBody
    @GetMapping("/{id}")
    public Employee returnDoctorInfo(@PathVariable Integer id) {
        return employeeService.findOneEmployeeById(id);
    }

    /**
     * 添加员工
     **/
//    @ResponseBody
    @PostMapping("/add")
    public String addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "forward:/admin/doctorAdd/page";
    }

    /**
     * 删除员工
     **/
    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return "success";
    }

    /**
     * 批量删除
     **/
    @ResponseBody
    @DeleteMapping("/deleteMore")
    public String deleteMore(@Param("ids") int[] ids) {
        try {
            for (int id : ids) {
                deleteEmployee(id);
            }
        } catch (Exception e) {
            return "failed";
        }
        return "success";
    }

    /**
     * 修改员工
     **/
    @ResponseBody
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setEmpId(id);
        employeeService.updateEmployee(employee);
        System.out.println(employee);
        return "success";
    }

    /**
     * 跳转对应id医生的个人简介页面
     */
    @GetMapping("/doctorIntro/page/{id}")
    public String toDoctorPage(@PathVariable Integer id, Model model) {
        //封装医生数据
        model.addAttribute("doctorInfo", employeeService.findOneEmployeeById(id));
        //封装医生出诊信息
        model.addAttribute("doctorReg", registerService.findRegisterByDoctorId(id));
        //返回页面
        return "doctorIntro";
    }
}
