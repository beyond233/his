package com.beyond233.his.service;

import java.util.Collection;
import java.util.Set;

/**
 * <p>项目文档: 权限</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 12:14
 */

public interface PermissionService {
    /**
     * 通过员工id查询员工的权限集合
     *
     * @param empId id
     * @return java.util.Collection<java.lang.String>
     * @since 2020/3/22 12:12
     */
    Set<String> findPermissionsByEmpId(int empId);

    /**
     * 通过角色集合查询其对应的权限集合
     *
     * @param roleCollection 角色集合
     * @return java.util.Collection<java.lang.String>
     * @since 2020/3/22 12:13
     */
    Collection<String> findPermissionCollectionByRoleCollection(Collection<String> roleCollection);

    ;
}
