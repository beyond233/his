package com.beyond233.his;

import com.beyond233.his.entity.User;
import com.beyond233.his.entity.UserExample;
import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class HisApplicationTests {
    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(1).andUserPasswordEqualTo("1");
        List<User> users = userMapper.selectByExample(example);
        if (users != null) {
            System.out.println(users.get(0));
        }

    }

}
