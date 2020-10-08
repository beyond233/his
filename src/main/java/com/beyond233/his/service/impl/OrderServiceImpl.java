package com.beyond233.his.service.impl;

import com.beyond233.his.entity.Order;
import com.beyond233.his.entity.OrderExample;
import com.beyond233.his.mapper.OrderMapper;
import com.beyond233.his.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: 就诊业务</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-16 0:19
 */
@Service
public class OrderServiceImpl {
    @Resource
    OrderMapper orderMapper;
    @Resource
    UserMapper userMapper;

    /**
     * 通过id获取对应就诊记录
     **/
    public Order getOrderByOrderId(int orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 通过用户id获取用户对应所有的就诊记录
     **/
//    public List<Order> getUserAllOrders(String userId) {
//        return userMapper.selectAllUserOrderRecords(userId);
//    }

    /**
     * 获取所有就诊记录
     **/
    public List<Order> getAllOrders() {
        OrderExample example = new OrderExample();
        example.createCriteria().andOrderIdIsNotNull();
        return orderMapper.selectByExampleWithBLOBs(example);
    }
    /**删除就诊记录**/
    /**修改就诊记录**/
    /**添加就诊记录**/

}
