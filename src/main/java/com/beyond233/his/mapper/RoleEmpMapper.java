package com.beyond233.his.mapper;

import com.beyond233.his.entity.RoleEmp;
import com.beyond233.his.entity.RoleEmpExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleEmpMapper {
    long countByExample(RoleEmpExample example);

    int deleteByExample(RoleEmpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleEmp record);

    int insertSelective(RoleEmp record);

    List<RoleEmp> selectByExample(RoleEmpExample example);

    RoleEmp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleEmp record, @Param("example") RoleEmpExample example);

    int updateByExample(@Param("record") RoleEmp record, @Param("example") RoleEmpExample example);

    int updateByPrimaryKeySelective(RoleEmp record);

    int updateByPrimaryKey(RoleEmp record);
}