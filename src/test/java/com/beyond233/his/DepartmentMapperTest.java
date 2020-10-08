package com.beyond233.his;

import com.beyond233.his.entity.Department;
import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.service.DepartmentService;
import com.beyond233.his.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-09 21:40
 */
@SpringBootTest
public class DepartmentMapperTest {
    @Resource
    DepartmentMapper mapper;
    @Resource
    DepartmentServiceImpl service;

    @Test
    public void test1() {
        Department department = new Department();
        department.setDepartmentId(7);
        department.setDepartmentAddr("嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        service.updateDepartment(department);

    }
}
