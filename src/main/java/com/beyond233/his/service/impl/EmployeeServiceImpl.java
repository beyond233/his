package com.beyond233.his.service.impl;

import com.beyond233.his.entity.Employee;
import com.beyond233.his.entity.EmployeeExample;
import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.mapper.EmployeeMapper;
import com.beyond233.his.vo.DepartmentIdAndNameRecord;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>项目文档: 员工服务</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-01 9:13
 */
@Service
public class EmployeeServiceImpl {
    @Resource
    EmployeeMapper employeeMapper;
    @Resource
    DepartmentMapper departmentMapper;

    /**
     * 管理页面数据封装1
     **/
    public Map<String, List> adminPageData() {
        List<DepartmentIdAndNameRecord> idAndNameList = departmentMapper.selectAllDepartIdAndName();
        List<String> typeList = departmentMapper.selectAllDepartmentTypes();
        HashMap<String, List> map = new HashMap<>(100);
        map.put("idAndNameList", idAndNameList);
        map.put("typeList", typeList);
        return map;
    }

    /**
     * 员工登录验证
     **/
    public void loginVerify(String phone, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpPhoneEqualTo(phone).andEmpPasswordEqualTo(password);
        List<Employee> employeeList = employeeMapper.selectByExample(example);
        //验证成功
        if (!employeeList.isEmpty()) {
            Employee employee = employeeList.get(0);
            request.getSession().setAttribute("empLogin", employee);
            if ("医生".equals(employee.getEmpCareer())) {
                //医生页面
                request.getRequestDispatcher("/emp/doctorPage").forward(request, response);
//                return 1;
            } else {
                //管理页面
                request.getRequestDispatcher("/emp/adminPage").forward(request, response);
//                return -1;
            }
        } else {//验证失败
            response.sendRedirect("/emp/emplogin.html");
        }
    }

    /**
     * 添加员工
     **/
    public void addEmployee(Employee employee) {
        int id = employeeMapper.selectMaxId() + 1;
        if (employee != null) {
            employee.setEmpId(id);
            employee.setEmpPassword("123");
            employeeMapper.insert(employee);
        }
    }

    /**
     * 删除员工
     **/
    public void deleteEmployeeById(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    /**
     * id查询员工
     **/
    public Employee findOneEmployeeById(Integer empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    /**
     * 手机号查询员工
     **/
    public Employee findEmployeeByPhone(String empPhone) {
        return employeeMapper.selectEmpByEmpPhone(empPhone);
    }

    /**
     * 修改员工
     **/
    public void updateEmployee(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 查询所有员工
     **/
    public List<Employee> findAllEmployee() {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andDepartmentIdIsNotNull();
        return employeeMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 按照员工类型查询员工信息
     **/
    public List<Employee> findAllEmployeeByCareer(String career) {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpCareerEqualTo(career);
        return employeeMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 查询所有管理人员
     **/
    public List<Employee> findAllManagers() {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpCareerEqualTo("管理");
        return employeeMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 查询所有医生
     **/
    public List<Employee> findAllDoctors() {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpCareerEqualTo("医生");
        return employeeMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 按照科室id查询其对应的医生信息
     **/
    public List<Employee> findAllDoctorsByDepartmentId(Integer departmentId) {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andDepartmentIdEqualTo(departmentId).andEmpCareerEqualTo("医生");
        return employeeMapper.selectByExampleWithBLOBs(example);
    }
//    /**按照科室名称查询其对应的医生信息**/
//    public List<Employee> findAllDoctorsByDepartmentName(String departmentName){
//        EmployeeExample example = new EmployeeExample();
//        example.createCriteria().andEmpCareerEqualTo("医生").;
//        return employeeMapper.selectByExampleWithBLOBs(example);
//    }

    /**
     * 分页查询医生
     **/
    public List<Employee> findDoctorsByPageNumAndSize(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpCareerEqualTo("医生");
        return employeeMapper.selectByExampleWithBLOBs(example);
    }
}
