package com.beyond233.his.vo;

import com.beyond233.his.entity.Employee;

import java.util.Set;

/**
 * <p>项目文档: 员工登录VO</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 11:09
 */
public class LoginEmployeeVO {
    private Employee employee;
    /**
     * 角色集合：员工承担的所有角色
     **/
    private Set<String> roles;
    /**
     * 权限集合：员工拥有的所有权限
     **/
    private Set<String> permissions;

    public LoginEmployeeVO() {
    }

    public LoginEmployeeVO(Employee employee, Set<String> roles, Set<String> permissions) {
        this.employee = employee;
        this.roles = roles;
        this.permissions = permissions;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "LoginEmployeeVO{" +
                "employee=" + employee +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
