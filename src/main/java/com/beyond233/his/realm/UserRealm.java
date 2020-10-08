package com.beyond233.his.realm;

import com.beyond233.his.vo.LoginUserVO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * <p>项目文档: 用户身份验证和授权</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-20 16:48
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 身份验证(为当前登录用户验证身份)
     *
     * @param token 令牌对象
     * @return org.apache.shiro.authc.AuthenticationInfo
     * @since 2020/3/20 12:06
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取登录对象信息
        String username = token.getPrincipal().toString();
        //获取盐值(以用户id作为盐值)
        ByteSource salt = ByteSource.Util.bytes(username);
        //创建登录对象
        //参数1：当前登录对象  参数2：密码  参数3：盐值 参数4：realm域名(这里以此类的短类名作为域名)
        return new SimpleAuthenticationInfo(null, null, null, "");
    }
}
