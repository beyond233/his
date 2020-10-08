package com.beyond233.his;

import com.beyond233.his.mapper.QAMapper;
import com.beyond233.his.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-05-17 16:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class QaMapperTest {

    @Autowired
    private QuestionService service;
    @Autowired
    private QAMapper mapper;

    @Test
    public void test1() {
        System.out.println(service.findQaLimit(1, 5, "办理"));

    }

}
