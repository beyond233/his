package com.beyond233.his;

import com.beyond233.his.mapper.RegisterMapper;
import com.beyond233.his.vo.ExpertRegisterRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-14 16:01
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RegisterMapperTest {
    @Resource
    RegisterMapper mapper;

    @Test
    public void test1() {
        List<ExpertRegisterRecord> expertRegisterRecords = mapper.selectAllExpertRegister();
        for (ExpertRegisterRecord expertRegisterRecord : expertRegisterRecords) {
            System.out.println(expertRegisterRecord);
        }
    }
}

