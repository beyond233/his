package com.beyond233.his.service.impl;

import com.beyond233.his.mapper.RoleMapper;
import com.beyond233.his.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 12:17
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    public Set<String> findRoleCollectionByEmpId(Integer userId) {
        return roleMapper.selectRoleCollectionByEmpId(userId);
    }
}
