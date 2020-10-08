package com.beyond233.his.service.impl;

import com.beyond233.his.entity.Department;
import com.beyond233.his.entity.DepartmentExample;
import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.service.DepartmentService;
import com.beyond233.his.vo.DepartmentIdAndNameRecord;
import com.beyond233.his.vo.DepartmentTypeAndName;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>项目文档: 科室相关的业务 </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-01 23:43
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;

    /**
     * 添加科室
     */
    @Override
    public void addDepartment(Department department) {
        if (departmentMapper.selectByPrimaryKey(department.getDepartmentId()) == null) {
            departmentMapper.insert(department);
        }
    }

    /**
     * 删除科室
     */
    @Override
    public void deleteDepartment(int departmentId) {
        departmentMapper.deleteByPrimaryKey(departmentId);

    }

    /**
     * 批量删除科室
     **/
    public void deleteDepartmentByIdList(List<Integer> idList) {
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepartmentIdIn(idList);
        departmentMapper.deleteByExample(example);
    }

    /**
     * 修改科室
     */
    @Override
    public void updateDepartment(Department department) {
        //根据已有信息更改对应的字段，而不是更改全部字段
        departmentMapper.updateByPrimaryKeySelective(department);

    }

    /**
     * 查询所有科室信息
     **/
    @Override
    public List<Department> findAllDepartments() {
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentIdIsNotNull();
        //longText类型数据要用withBLOBs方法查询，这样才会查询出表中大字段的数据
        return departmentMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 通过id查询对应的科室信息
     **/
    @Override
    public Department findDepartmentById(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据科室类型查询出属于此类的全部科室
     */
    public List<Department> findDepartmentsByType(String departmentType) {
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepartmentTypeEqualTo(departmentType);
        return departmentMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 查询全部的科室类型
     **/
    public List<String> findAllDepartTypes() {
        return departmentMapper.selectAllDepartmentTypes();
    }

    /**
     * 封装所有科室类型及其对应的全部科室的信息（科室id与name）
     **/
    public List<DepartmentTypeAndName> findDepartmentTypeAndName() {
        List<DepartmentTypeAndName> list = new ArrayList<>();
        //查询出所有科室类型
        List<String> allDepartTypes = this.findAllDepartTypes();
        //遍历类型list，逐个封装数据
        for (String departType : allDepartTypes) {
            DepartmentTypeAndName data = new DepartmentTypeAndName();
            //封装数据
            data.setDepartType(departType);
            data.setDepartList(departmentMapper.selectDepartIdAndNameByType(departType));
            list.add(data);
        }
        return list;
    }

    /**
     * 封装所有的科室id和name
     **/
    public List<DepartmentIdAndNameRecord> findAllDepartIdAndName() {
        return departmentMapper.selectAllDepartIdAndName();
    }


}
