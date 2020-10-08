package com.beyond233.his.token;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 15:26
 */
public class EmpPhonePasswordToken implements HostAuthenticationToken, RememberMeAuthenticationToken, Serializable {
    /**
     * 登录员工的手机号
     **/
    private String empPhone;
    /**
     * 登录员工的密码
     **/
    private char[] password;
    /**
     * 是否记住登录员工信息
     **/
    private boolean rememberMe = false;
    /**
     * host
     **/
    private String host;

    public EmpPhonePasswordToken() {
    }

    public EmpPhonePasswordToken(String empPhone) {
        this.empPhone = empPhone;
    }

    public EmpPhonePasswordToken(String empPhone, String password) {
        this.empPhone = empPhone;
        this.password = password != null ? password.toCharArray() : null;
    }

    public EmpPhonePasswordToken(String empPhone, char[] password, boolean rememberMe) {
        this.empPhone = empPhone;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public EmpPhonePasswordToken(String empPhone, char[] password, boolean rememberMe, String host) {
        this.empPhone = empPhone;
        this.password = password;
        this.rememberMe = rememberMe;
        this.host = host;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public boolean isRememberMe() {
        return rememberMe;
    }

    /**
     * 返回登录对象的手机号
     *
     * @return java.lang.Object
     * @since 2020/3/22 15:27
     */
    @Override
    public Object getPrincipal() {
        return getEmpPhone();
    }

    /**
     * 返回登录对象的密码
     *
     * @return java.lang.Object
     * @since 2020/3/22 15:27
     */
    @Override
    public Object getCredentials() {
        return getPassword();
    }

    @Override
    public String toString() {
        return "EmpPhonePasswordToken{" +
                "empPhone='" + empPhone + '\'' +
                ", password=" + Arrays.toString(password) +
                ", rememberMe=" + rememberMe +
                ", host='" + host + '\'' +
                '}';
    }
}
