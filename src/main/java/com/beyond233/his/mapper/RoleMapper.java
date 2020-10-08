package com.beyond233.his.mapper;

import com.beyond233.his.entity.Role;
import com.beyond233.his.entity.RoleExample;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

/**
 * @author BEYOND233
 */
public interface RoleMapper {
    /**
     * 通过员工id查询员工的角色列表
     *
     * @param empId id
     * @return java.util.Collection<java.lang.String>
     * @since 2020/3/22 12:10
     */
    Set<String> selectRoleCollectionByEmpId(Integer empId);

    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}