package com.beyond233.his.realm;

import com.beyond233.his.entity.Employee;
import com.beyond233.his.entity.User;
import com.beyond233.his.service.EmployeeService;
import com.beyond233.his.service.PermissionService;
import com.beyond233.his.service.RoleService;
import com.beyond233.his.service.impl.EmployeeServiceImpl;
import com.beyond233.his.token.EmpPhonePasswordToken;
import com.beyond233.his.vo.LoginEmployeeVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hibernate.validator.internal.constraintvalidators.hv.ModCheckBase;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>项目文档: 员工权限授予和身份验证 </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 11:07
 */
public class EmployeeRealm extends AuthorizingRealm {
    @Resource
    EmployeeServiceImpl employeeService;
    @Resource
    RoleService roleService;
    @Resource
    PermissionService permissionService;

    /**
     * 权限授予
     *
     * @param principals 登录主体对象
     * @return org.apache.shiro.authz.AuthorizationInfo
     * @since 2020/3/22 11:08
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        try {
            //获取登录员工的 VO对象
            LoginEmployeeVO employeeVO = (LoginEmployeeVO) principals.getPrimaryPrincipal();
            //获取角色列表
            Set<String> roles = employeeVO.getRoles();
            //获取权限列表
            Set<String> permissions = employeeVO.getPermissions();
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //设置角色列表
            if (roles != null && !roles.isEmpty()) {
                info.setRoles(roles);
            }
            //设置权限列表
            if (permissions != null && !permissions.isEmpty()) {
                info.setStringPermissions(permissions);
            }
            //授权成功
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //授权失败
        return null;
    }

    /**
     * 身份验证
     *
     * @param token 令牌对象
     * @return org.apache.shiro.authc.AuthenticationInfo
     * @since 2020/3/22 11:09
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        try {
            //创建一个自定义的EmpPhonePasswordToken，准备接收令牌对象
            EmpPhonePasswordToken empToken;
            //将token转为自定义的EmpPhonePasswordToken
            if (token instanceof EmpPhonePasswordToken) {
                empToken = (EmpPhonePasswordToken) token;
            } else {
                return null;
            }
            //获取当前令牌登录对象的信息
            String empPhone = empToken.getPrincipal().toString();
            //调用根据员工手机号查询用户信息的方法
            Employee employee = employeeService.findEmployeeByPhone(empPhone);
            //判断对象是否为空
            if (employee != null) {
                //查询角色列表
                Set<String> roles = (Set<String>) roleService.findRoleCollectionByEmpId(employee.getEmpId());
                //查询权限列表
                Set<String> permissions = (Set<String>) permissionService.findPermissionsByEmpId(employee.getEmpId());
                //创建登录用户对象，传入用户信息，角色列表，权限列表
                LoginEmployeeVO loginVO = new LoginEmployeeVO(employee, roles, permissions);
                //创建盐值(以用户名作为盐值)
                ByteSource salt = ByteSource.Util.bytes(employee.getEmpName());
                //创建身份验证对象
                //参数1：当前登录对象  参数2：密码  参数3：盐值 参数4：域名
                return new SimpleAuthenticationInfo(loginVO, employee.getEmpPassword(), salt, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //验证失败
        return null;
    }

    /**
     * 重写support()方法，告诉shiro允许接收EmpPhonePasswordToken类型的token对象
     *
     * @param token 接收的包含用户登录信息的令牌对象
     * @return boolean
     * @since 2020/3/22 16:07
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof EmpPhonePasswordToken;
    }
}
