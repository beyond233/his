package com.beyond233.his.vo;

import com.beyond233.his.entity.User;

import java.util.Set;

/**
 * <p>项目文档: 用户登录对象</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-20 17:14
 */
public class LoginUserVO {
    //登录对象
    private User user;
    //用户角色列表
    private Set<String> roles;
    //用户权限列表
    private Set<String> permissions;

    public LoginUserVO() {
    }

    public LoginUserVO(User user, Set<String> roles, Set<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "LoginUserVO{" +
                "user=" + user +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
