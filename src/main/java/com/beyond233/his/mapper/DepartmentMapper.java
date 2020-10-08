package com.beyond233.his.mapper;

import com.beyond233.his.entity.Department;
import com.beyond233.his.entity.DepartmentExample;

import java.util.List;

import com.beyond233.his.vo.DepartmentIdAndNameRecord;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    /**
     * 查询所有的科室类型
     **/
    List<String> selectAllDepartmentTypes();

    /**
     * 查询所有科室id和对应的名称
     **/
    List<DepartmentIdAndNameRecord> selectAllDepartIdAndName();

    /**
     * 根据科室类型查询出对应的科室id，name的集合
     **/
    List<DepartmentIdAndNameRecord> selectDepartIdAndNameByType(String departType);

    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer departmentId);

    List<Department> selectByExampleWithBLOBs(DepartmentExample example);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExampleWithBLOBs(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKeyWithBLOBs(Department record);

    int updateByPrimaryKey(Department record);
}