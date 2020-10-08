package com.beyond233.his;

import com.beyond233.his.entity.User;
import com.beyond233.his.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-03 14:07
 */
@SpringBootTest
public class UserExampleUpdateTest {
    @Resource
    UserMapper userMapper;

    @Test
    public void test1() {
        User user = new User();
        user.setUserId(100);
        user.setUserPassword("9");
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andUserNameIsNull();
//        userMapper.updateByExample(user, userExample);
//        userMapper.updateByPrimaryKeySelective(user);
        userMapper.updateByPrimaryKey(user);

    }
}
