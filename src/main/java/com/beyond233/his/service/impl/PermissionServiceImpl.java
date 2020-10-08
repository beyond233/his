package com.beyond233.his.service.impl;

import com.beyond233.his.mapper.PermissionMapper;
import com.beyond233.his.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 12:18
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionMapper permissionMapper;

    @Override
    public Set<String> findPermissionsByEmpId(int empId) {
        return permissionMapper.selectPermissionsByEmpId(empId);
    }

    @Override
    public Collection<String> findPermissionCollectionByRoleCollection(Collection<String> roleCollection) {
        return permissionMapper.selectPermissionCollectionByRoleCollection(roleCollection);
    }
}
