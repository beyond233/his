package com.beyond233.his.mapper;

import com.beyond233.his.entity.Permission;
import com.beyond233.his.entity.PermissionExample;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.slf4j.MDCContextMap;

public interface PermissionMapper {
    /**
     * 通过员工id查询员工的权限集合
     *
     * @param empId id
     * @return java.util.Collection<java.lang.String>
     * @since 2020/3/22 12:12
     */
    Set<String> selectPermissionsByEmpId(int empId);

    /**
     * 通过角色集合查询其对应的权限集合
     *
     * @param roleCollection 角色集合
     * @return java.util.Collection<java.lang.String>
     * @since 2020/3/22 12:13
     */
    Collection<String> selectPermissionCollectionByRoleCollection(Collection<String> roleCollection);

    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}