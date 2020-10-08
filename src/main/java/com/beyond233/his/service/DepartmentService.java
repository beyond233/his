package com.beyond233.his.service;

import com.beyond233.his.entity.Department;

import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-01 23:45
 */
public interface DepartmentService {
    /**
     * 添加科室
     **/
    void addDepartment(Department department);

    /**
     * 删除科室
     **/
    void deleteDepartment(int departmentId);

    /**
     * 修改科室
     **/
    void updateDepartment(Department department);

    /**
     * 查询所有科室
     **/
    List<Department> findAllDepartments();

    /**
     * 通过id查询指定科室
     **/
    Department findDepartmentById(Integer id);

    /**
     * 通过多种条件来查询科室
     **/
//    Department selectDepartmentByExample(Department department);

}
