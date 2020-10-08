package com.beyond233.his.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * <p>项目文档: 患者相关服务</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-02-29 22:09
 */
@Service
public interface AccountService {
    /**
     * 登录验证
     */
    int loginVerify(String id, String password, HttpServletRequest request);

    /**
     * 注册
     */
    boolean signUp(Object object, HttpServletRequest request);

    /**
     * 验证id是否合法
     */
    boolean signUpIdVerify(@NotNull String id);

    /**
     * 验证密码是否合法
     */
    boolean signUpPasswordVerify(@NotNull String password);

    /**
     * 删除账户
     */
    boolean deleteAccount(String id);
}
