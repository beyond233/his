package com.beyond233.his;

import com.beyond233.his.entity.Department;
import com.beyond233.his.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-03 14:33
 */
@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    DepartmentService service;

    @Test
    public void test1() {
        for (Department department : service.findAllDepartments()) {
            System.out.println(department);
        }
    }
}
