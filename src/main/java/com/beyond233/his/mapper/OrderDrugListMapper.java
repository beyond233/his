package com.beyond233.his.mapper;

import com.beyond233.his.entity.OrderDrugList;
import com.beyond233.his.entity.OrderDrugListExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderDrugListMapper {
    long countByExample(OrderDrugListExample example);

    int deleteByExample(OrderDrugListExample example);

    int insert(OrderDrugList record);

    int insertSelective(OrderDrugList record);

    List<OrderDrugList> selectByExample(OrderDrugListExample example);

    int updateByExampleSelective(@Param("record") OrderDrugList record, @Param("example") OrderDrugListExample example);

    int updateByExample(@Param("record") OrderDrugList record, @Param("example") OrderDrugListExample example);
}