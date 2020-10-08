package com.beyond233.his.controller;

import com.beyond233.his.entity.User;
import com.beyond233.his.service.impl.UserServiceImpl;
import com.beyond233.his.token.EmpPhonePasswordToken;
import com.beyond233.his.vo.UserOrderRecord;
import com.beyond233.his.vo.UserRegisterRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>项目文档:用户增删查改 </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @date 2020-02-17 14:33
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    /**
     * 用户修改个人信息
     **/
    @ResponseBody
    @PostMapping("/update")
    public User updateUserInfo(User user, HttpServletRequest request) {
        User login = (User) request.getSession().getAttribute("login");
        user.setUserId(login.getUserId());
        userService.updateUser(user);
        //更改信息后刷新session中的user信息
        userService.loginVerify(login.getUserPhone(), login.getUserPassword(), request);
        return user;
    }

    /**
     * 修改患者信息
     *
     * @param user ，
     * @param id，
     * @return java.lang.String
     * @since 2020/3/24 22:16
     */
    @ResponseBody
    @PostMapping("/{id}")
    public String updateUser(User user, @PathVariable int id) {
        try {
            user.setUserId(id);
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    /**
     * 删除user
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id) ? "删除成功" : "删除失败";
    }

    /**
     * 批量删除user
     */
    @ResponseBody
    @DeleteMapping("/deleteMore")
    public String deleteMoreUser(int[] ids) {
        try {
            for (int id : ids) {
                deleteUser(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    /**
     * 查找user
     **/
    @ResponseBody
    @GetMapping("/{id}")
    public String selectUser(@PathVariable int id) {
        return "正在查找id为" + id + "的员工信息";
    }

    /**
     * 分页查询user
     **/
    @ResponseBody
    @GetMapping("/limit")
    public Map<String, Object> selectLimitUser(int page, int limit) {
        Map<String, Object> map = new HashMap<>(20);
        //用户总数
        int count = userService.findTotalUserCount();
        //全部用户
        List<User> allUsers = userService.findAllUsers();
        map.put("code", 0);
        map.put("message", "");
        map.put("count", count);
        map.put("data", allUsers);
        return map;
    }

    /**
     * 个人中心
     **/
    @RequestMapping("/space")
    public String userSpace(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("login");
        return "userspace";
    }

    /**
     * 修改手机号
     **/
    @ResponseBody
    @PostMapping("/update/phone")
    public String updateId(HttpServletRequest request, @RequestBody User user) {
        user.setUserId(user.getUserId());
        User loginUser = (User) request.getSession().getAttribute("login");
        if (user.getUserPassword().equals(loginUser.getUserPassword())) {
            //验证手机号是否被其他账号绑定
            String userPhone = user.getUserPhone();
            if (userService.signUpPhoneVerify(userPhone)) {
                //手机号可用
                user.setUserId(loginUser.getUserId());
                userService.updateUser(user);
                return "true";
            } else {
                //手机号已被其他手机号绑定
                return "disabled";
            }
        } else {
            return "false";
        }
    }

    /**
     * 修改密码
     **/
    @ResponseBody
    @RequestMapping(value = "/update/password", method = RequestMethod.POST)
    public String updatePassword(@RequestParam("newPassword") String newPassword, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("login");
        //验证新密码
        if (newPassword != null && !"".equals(newPassword)) {
            //设置新密码
            user.setUserPassword(newPassword);
            userService.updateUser(user);
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 密码验证
     **/
    @ResponseBody
    @PostMapping("/passwordJudge")
    public String passwordJudge(@RequestParam("password") String password, HttpServletRequest request) {
        System.out.println("客户端： " + password);
        User user = (User) request.getSession().getAttribute("login");
        System.out.println("用户：" + user.getUserPassword());
        if (password.equals(user.getUserPassword())) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 预约记录查询
     **/
    @ResponseBody
    @GetMapping("/registerRecordQuery")
    public List<UserRegisterRecord> userRegistrationQuery(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("login");
        return userService.findAllUserRegisterRecords(user.getUserId());
    }

    /**
     * 通过用户ID查询其所有的就诊记录
     **/
    @ResponseBody
    @GetMapping("/orderRecordQuery")
    public List<UserOrderRecord> userOrderRecordsQuery(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("login");
        return userService.findAllUserOrderRecords(user.getUserId());
    }

    @PostMapping("/resetPassword")
    public String updateUserPassword(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletRequest request) {
        if (phone != null) {
            User user = userService.findUserByPhone(phone);
            if (user != null) {
                Integer userId = user.getUserId();
                String r = userService.updateUserPassword(userId, password);
                if ("success".equals(r)) {
                    //跳转登录
                    request.setAttribute("info", "重置密码成功！请登录");
                    return "login";
                }
            }
        }
        request.setAttribute("info", "重置密码失败！该用户尚未注册");
        return "reset";
    }

}
