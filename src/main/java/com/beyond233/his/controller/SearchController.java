package com.beyond233.his.controller;

import com.beyond233.his.entity.Department;
import com.beyond233.his.entity.DepartmentExample;
import com.beyond233.his.entity.Employee;
import com.beyond233.his.entity.EmployeeExample;
import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>项目文档: 搜索控制器</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-05-21 17:29
 */
@Controller
public class SearchController {

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    @PostMapping("/search")
    public String search(@RequestParam("keyWord") String keyWord, Model model) {
        HashMap<String, Object> empMap = new HashMap<>(50);
        HashMap<String, Object> depMap = new HashMap<>(50);
        //搜索医生
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpNameLike("%" + keyWord + "%");
        List<Employee> employees = employeeMapper.selectByExampleWithBLOBs(example);
        empMap.put("employees", employees);
        empMap.put("count", employees.size());
        model.addAttribute("empMap", empMap);

        //搜索科室
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentNameLike("%" + keyWord + "%");
        List<Department> departments = departmentMapper.selectByExampleWithBLOBs(departmentExample);
        depMap.put("departments", departments);
        depMap.put("count", departments.size());
        model.addAttribute("depMap", depMap);

        return "search";
    }


}
