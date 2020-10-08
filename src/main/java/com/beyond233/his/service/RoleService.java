package com.beyond233.his.service;

import java.util.Collection;
import java.util.Set;

/**
 * <p>项目文档: 角色</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 12:16
 */
public interface RoleService {
    /**
     * 通过员工id查询员工的角色列表
     *
     * @param userId id
     * @return java.util.Collection<java.lang.String>
     * @since 2020/3/22 12:10
     */
    Set<String> findRoleCollectionByEmpId(Integer userId);

}
