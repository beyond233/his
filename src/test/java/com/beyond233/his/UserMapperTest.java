package com.beyond233.his;

import com.beyond233.his.mapper.UserMapper;
//import com.beyond233.his.mapper.UserPlusMapper;
import com.beyond233.his.vo.UserRegisterRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-05 20:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Resource
    UserMapper userMapper;
//    @Autowired
//    UserPlusMapper userPlusMapper;

    @Test
    public void test1() {
        List<UserRegisterRecord> userOrderRecords = userMapper.selectAllUserRegisterRecords(1);
        for (UserRegisterRecord userOrderRecord : userOrderRecords) {
            System.out.println(userOrderRecord);
        }
    }

    @Test
    public void test2() {
        System.out.println(userMapper.selectDemo(1, "男"));
    }

    @Test
    public void test3(){
//        List list = userPlusMapper.selectList(null);
//        list.forEach(System.out::println);
    }

    @Test
    public void test4(){
        System.out.println(userMapper.pickOneUserById(1));
//        System.out.println(userMapper.selectUserByUserPhone("1"));
    }


}


