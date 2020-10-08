package com.beyond233.his.mapper;

import com.beyond233.his.entity.RegisterOrder;
import com.beyond233.his.entity.RegisterOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RegisterOrderMapper {
    long countByExample(RegisterOrderExample example);

    int deleteByExample(RegisterOrderExample example);

    int insert(RegisterOrder record);

    int insertSelective(RegisterOrder record);

    List<RegisterOrder> selectByExample(RegisterOrderExample example);

    int updateByExampleSelective(@Param("record") RegisterOrder record, @Param("example") RegisterOrderExample example);

    int updateByExample(@Param("record") RegisterOrder record, @Param("example") RegisterOrderExample example);
}