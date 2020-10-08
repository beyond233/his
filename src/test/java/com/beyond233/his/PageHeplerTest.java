package com.beyond233.his;

import com.beyond233.his.entity.Employee;
import com.beyond233.his.entity.EmployeeExample;
import com.beyond233.his.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
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
 * @since 2020-03-12 10:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageHeplerTest {
    @Resource
    EmployeeMapper mapper;

    @Test
    public void test1() {
        PageHelper.startPage(1, 5);
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpIdIsNotNull();
        List<Employee> employeeList = mapper.selectByExampleWithBLOBs(example);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
