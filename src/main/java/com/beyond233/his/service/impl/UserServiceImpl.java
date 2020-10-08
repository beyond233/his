package com.beyond233.his.service.impl;

import com.beyond233.his.entity.User;
import com.beyond233.his.entity.UserExample;
import com.beyond233.his.mapper.UserMapper;
import com.beyond233.his.vo.UserOrderRecord;
import com.beyond233.his.vo.UserRegisterRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-01 9:06
 */
@Service
public class UserServiceImpl {
    @Resource
    UserMapper userMapper;

    /**
     * 登录验证
     **/
    public int loginVerify(String phone, String password, HttpServletRequest request) {
        //先判断用户是否注册
        if (userMapper.selectUserByUserPhone(phone) == null) {
            request.setAttribute("loginVerify", "用户尚未注册");
            //未注册返回-1
            return -1;
        }
        //验证密码
        UserExample example = new UserExample();
        example.createCriteria().andUserPhoneEqualTo(phone).andUserPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && !users.isEmpty()) {
            request.getSession().setAttribute("login", users.get(0));
            //密码正确返回1
            return 1;
        } else {
            request.setAttribute("loginVerify", "密码错误");
            //密码错误返回0
            return 0;
        }
    }


    /**
     * 用户注册
     * true:成功
     * false：失败
     **/
    public boolean signUp(Object object, HttpServletRequest request) {
        User user = (User) object;
        //判断id是否合法
        if (this.signUpPhoneVerify(user.getUserPhone())) {
            //进一步判断密码是否合法
            if (this.signUpPasswordVerify(user.getUserPassword())) {
                //均合法
                userMapper.insert(user);
                return true;
            } else {  //密码不合法
                request.setAttribute("signUpVerify", "密码不合法，请重新输入");
                return false;
            }
        } else {  //id不合法
            request.setAttribute("signUpVerify", "id不合法，请重新输入");
            return false;
        }
    }

    /**
     * 验证用户输入的手机号是否已经被注册
     * false:手机号已注册，不可用
     * true:手机号还未注册，可用
     **/
    public boolean signUpPhoneVerify(@NotNull String phone) {
        return userMapper.selectUserByUserPhone(phone) == null;
    }

    /**
     * 验证用户输入的密码是否合法
     * false:密码不合法
     * true:密码合法
     */
    public boolean signUpPasswordVerify(@NotNull String password) {
        return true;
    }

    /**
     * 完善个人信息
     */
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 删除用户
     **/
    public boolean deleteUser(int id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 根据用户id查询其预约记录
     **/
    public List<UserRegisterRecord> findAllUserRegisterRecords(int userId) {
        return userMapper.selectAllUserRegisterRecords(userId);
    }

    /**
     * 通过用户ID查询其所有的就诊记录
     **/
    public List<UserOrderRecord> findAllUserOrderRecords(int userId) {
        return userMapper.selectAllUserOrderRecords(userId);
    }

    /**
     * 查询用户总数
     *
     * @return int
     * @since 2020/3/24 22:05
     */
    public int findTotalUserCount() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIsNotNull();
        return userMapper.selectByExample(userExample).size();
    }

    /**
     * 查询全部用户
     *
     * @return java.util.List<com.beyond233.his.entity.User>
     * @since 2020/3/24 22:09
     */
    public List<User> findAllUsers() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIsNotNull();
        return userMapper.selectByExample(userExample);
    }

    public String updateUserPassword(Integer userId, String password) {
        if (userId != null && password != null) {
            userMapper.updateUserPassword(userId, password);
            return "success";
        } else {
            return "error";
        }
    }

    public User findUserByPhone(String phone) {
        if (phone != null) {
            UserExample example = new UserExample();
            example.createCriteria().andUserPhoneEqualTo(phone);
            List<User> users = userMapper.selectByExample(example);
            if (users.size() > 0) {
                return users.get(0);
            }
        }
        return null;
    }
}
