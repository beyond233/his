package com.beyond233.his.mapper;

import com.beyond233.his.entity.Employee;
import com.beyond233.his.entity.EmployeeExample;

import java.util.List;

import com.beyond233.his.vo.DepartmentIdAndNameRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author BEYOND
 */
@Repository
public interface EmployeeMapper {
    /**
     * 查询所有的科室类型
     *
     * @return java.util.List<java.lang.String>
     * @since 2020/3/22 10:36
     */
    List<String> selectAllDepartmentTypes();

    /**
     * 查询所有科室id和对应的名称
     *
     * @return java.util.List<com.beyond233.his.vo.DepartmentIdAndNameRecord>
     * @since 2020/3/22 10:36
     */
    List<DepartmentIdAndNameRecord> selectAllDepartIdAndName();

    /**
     * 根据科室类型查询出对应的科室id，name的集合
     *
     * @param departType 科室类型
     * @return java.util.List<com.beyond233.his.vo.DepartmentIdAndNameRecord>
     * @since 2020/3/22 10:35
     */
    List<DepartmentIdAndNameRecord> selectDepartIdAndNameByType(String departType);

    /**
     * 通过手机号查询员工
     *
     * @param empPhone 手机号
     * @return com.beyond233.his.entity.Employee
     * @since 2020/3/22 11:22
     */
    Employee selectEmpByEmpPhone(String empPhone);

    Integer selectMaxId();

    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExampleWithBLOBs(EmployeeExample example);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExampleWithBLOBs(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKeyWithBLOBs(Employee record);

    int updateByPrimaryKey(Employee record);
}