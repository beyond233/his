package com.beyond233.his.controller;

import com.alibaba.druid.sql.ast.SQLLimit;
import com.beyond233.his.entity.Department;
import com.beyond233.his.service.impl.DepartmentServiceImpl;
import com.beyond233.his.service.impl.EmployeeServiceImpl;
import com.beyond233.his.service.impl.RegisterServiceImpl;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>项目文档: 科室</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-01 23:23
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    DepartmentServiceImpl departmentService;
    @Resource
    EmployeeServiceImpl employeeService;
    @Resource
    RegisterServiceImpl registerService;

    /**
     * 跳转科室页面，返回所有科室信息
     **/
    @GetMapping("/page")
    public String departmentPage(Model model) {
        model.addAttribute("departmentList", departmentService.findDepartmentTypeAndName());
        return "department";
    }

    /**
     * 添加科室
     **/
    @PostMapping("/add")
    public ModelAndView addOneDepartment(Department department, ModelAndView modelAndView) {
        departmentService.addDepartment(department);
        modelAndView.setViewName("redirect:/department/add/page");
        return modelAndView;
    }

    /**
     * 查询科室
     */
    @GetMapping("/{id}")
    public String findOneDepartment(@NotNull @PathVariable Integer id, Model model) {
        model.addAttribute("department", departmentService.findDepartmentById(id));
        model.addAttribute("registerList", registerService.findRegisterInfo(id));
        return "departmentIntro";
    }

    /**
     * 修改科室
     */
    @PutMapping("/{id}")
    public void updateDepartment(@NotNull @PathVariable Integer id, @RequestBody Department department) {
        department.setDepartmentId(id);
        departmentService.updateDepartment(department);
    }

    /**
     * 删除科室
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteDepartment(@NotNull @PathVariable int id) {
        departmentService.deleteDepartment(id);
        return "success";
    }

    /**
     * 批量删除科室
     **/
    @ResponseBody
    @DeleteMapping("/deleteMore")
    public String deleteMoreDepartments(@Param("ids") int[] ids) {
        List<Integer> list = Arrays.stream(ids).boxed().collect(Collectors.toList());
        departmentService.deleteDepartmentByIdList(list);
        return "success";
    }

    /**
     * 根据科室类型查询出属于此类的全部科室，并返回管理页面
     */
    @GetMapping("/type")
    public String findDepartmentsByType(@RequestParam("type") String departmentType, Model model) {
        model.addAttribute("departList", departmentService.findDepartmentsByType(departmentType));
        model.addAttribute("departmentType", departmentType);
        model.addAttribute("adminMap", employeeService.adminPageData());
        return "emp/departadmin";
    }

    /**
     * 根据科室类型查询出属于此类的全部科室，并返回其json数据
     */
    @ResponseBody
    @GetMapping("/type/data")
    public Map<String, Object> returnDepartmentsByType(@RequestParam("type") String departmentType) {
        List<Department> departmentList = departmentService.findDepartmentsByType(departmentType);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "");
        map.put("total", departmentList.size());
        map.put("data", departmentList);
        return map;
    }

    /**
     * 返回所有的科室
     */
    @ResponseBody
    @GetMapping("/all/data")
    public Map<String, Object> returnAllDepartments() {
        List<Department> departmentList = departmentService.findAllDepartments();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "");
        map.put("total", departmentList.size());
        map.put("data", departmentList);
        return map;
    }

    /**
     * 返回所有的科室
     */
    @ResponseBody
    @GetMapping("/limit")
    public Map<String, Object> returnLimitDepartments(int page, int limit) {
        int count = departmentService.findAllDepartments().size();
        PageHelper.startPage(page, limit);
        List<Department> departmentList = departmentService.findAllDepartments();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "");
        map.put("count", count);
        map.put("data", departmentList);
        return map;
    }


    @RequestMapping(value = "/manager/page", method = {RequestMethod.POST, RequestMethod.GET})
    public String toDepartManagerPage(Model model) {
        //封装管理界面侧边导航栏数据
        model.addAttribute("adminMap", employeeService.adminPageData());
        //返回 科室管理-统一管理页面
        return "/emp/departmanager";
    }

    @RequestMapping(value = "/add/page", method = {RequestMethod.POST, RequestMethod.GET})
    public String toDepartAddPage(Model model) {
        //封装管理界面侧边导航栏数据
        model.addAttribute("adminMap", employeeService.adminPageData());
        //返回 科室管理-统一管理页面
        return "/emp/departmentAdd";
    }


}
