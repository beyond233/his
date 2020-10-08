package com.beyond233.his.service.impl;

import com.beyond233.his.entity.Register;
import com.beyond233.his.entity.RegisterExample;
import com.beyond233.his.entity.RegisterOrder;
import com.beyond233.his.entity.RegisterOrderExample;
import com.beyond233.his.mapper.DepartmentMapper;
import com.beyond233.his.mapper.RegisterMapper;
import com.beyond233.his.mapper.RegisterOrderMapper;
import com.beyond233.his.vo.ExpertRegisterRecord;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档:挂号服务 </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-08 14:24
 */
@Service
public class RegisterServiceImpl {
    @Resource
    RegisterMapper registerMapper;
    @Resource
    RegisterOrderMapper registerOrderMapper;
    @Resource
    DepartmentMapper departmentMapper;

    /**
     * 通过科室id查询其对应的挂号排班信息
     **/
    public List<ExpertRegisterRecord> findRegisterInfo(Integer departmentId) {
        return registerMapper.selectAllRegistersByDepartId(departmentId);

    }

    /**
     * 传入患者id和挂号id实现患者挂号功能
     * 号数余额减1，反馈给前端号数余额
     * 用户挂号表增加挂号信息
     **/
    public void userRegister(int userId, int registerId) {
        //判断用户是否已经挂过该科室的号，防止重复挂号
        RegisterOrderExample registerOrderExample = new RegisterOrderExample();
        registerOrderExample.createCriteria().andRegisterIdEqualTo(registerId).andUserIdEqualTo(userId);
        //若用户未挂过号则进行挂号
        if (registerOrderMapper.selectByExample(registerOrderExample).isEmpty()) {
            //判断是否还有剩余号数，号数余额减1
            Integer balance = registerMapper.selectByPrimaryKey(registerId).getRegisterBalance();
            if (balance > 0) {
                //还有剩余号数，号数余额减1
                balance -= 1;
                Register register = new Register();
                register.setRegisterBalance(balance);
                register.setRegisterId(registerId);
                registerMapper.updateByPrimaryKeySelective(register);
                //反馈信息给前端
                //用户挂号表增加挂号信息
                RegisterOrder registerOrder = new RegisterOrder();
                registerOrder.setRegisterId(registerId);
                registerOrder.setUserId(userId);
                registerOrder.setStatus(1);
                registerOrderMapper.insert(registerOrder);
            } else { //无剩余号数
                System.out.println();
            }
        } else { //用户已经挂过该号
            System.out.println("用户已经挂过该号");
        }
    }

    /**
     * 用户取消已经挂的号
     **/
    public void userRegisterCancel(int userId, int registerId) {
        //判断用户是否已经挂过该科室的号，防止误操作
        RegisterOrderExample registerOrderExample = new RegisterOrderExample();
        registerOrderExample.createCriteria().andRegisterIdEqualTo(registerId).andUserIdEqualTo(userId);
        List<RegisterOrder> registerOrders = registerOrderMapper.selectByExample(registerOrderExample);
        //若用户已经挂过该号，那才可以进行取消挂号
        if (!registerOrders.isEmpty()) {
            //判断号的状态是否可用，可用才能取消挂号
            if (registerOrders.get(0).getStatus() == 1) {
                //删除用户挂号表中对应数据
                registerOrderMapper.deleteByExample(registerOrderExample);
                //register数据表中对应号的余额加 1
                Register register = registerMapper.selectByPrimaryKey(registerId);
                register.setRegisterBalance(register.getRegisterBalance() + 1);
                registerMapper.updateByPrimaryKeySelective(register);

            } else {
                System.out.println("该号已过期，不可以退号");
            }
        }
    }

    /**
     * 查询该医生的挂号排班信息
     *
     * @param doctorId
     **/
    public List<Register> findRegisterByDoctorId(int doctorId) {
        RegisterExample example = new RegisterExample();
        example.createCriteria().andEmpIdEqualTo(doctorId);
        return registerMapper.selectByExample(example);
    }

    /**
     * 查询专家出诊信息
     **/
    public List<ExpertRegisterRecord> findAllExpertRegisterInfo() {
        return registerMapper.selectAllExpertRegister();
    }


}
