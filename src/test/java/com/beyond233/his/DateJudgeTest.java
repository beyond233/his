package com.beyond233.his;

import com.beyond233.his.entity.Register;
import com.beyond233.his.entity.RegisterExample;
import com.beyond233.his.mapper.RegisterMapper;
import com.beyond233.his.util.OutOfDateJudgeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>项目文档: 判断时间是否过期</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-13 11:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DateJudgeTest {
    @Resource
    RegisterMapper mapper;

    @Test
    public void test1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date currentDate = new Date();
//        String s = simpleDateFormat.format(currentDate);
        System.out.println("当前时间：" + currentDate);
        //获取挂号的排班时间
        Register register = mapper.selectByPrimaryKey(1);
        Date registerDate = register.getRegisterDate();
        System.out.println("挂号时间" + simpleDateFormat.format(registerDate));
        System.out.println("先后：" + OutOfDateJudgeUtil.beforeIfCurrentTime(registerDate));
    }
}
