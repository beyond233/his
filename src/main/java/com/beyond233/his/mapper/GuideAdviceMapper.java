package com.beyond233.his.mapper;

import com.beyond233.his.entity.GuideAdvice;
import com.beyond233.his.entity.GuideAdviceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GuideAdviceMapper {
    long countByExample(GuideAdviceExample example);

    int deleteByExample(GuideAdviceExample example);

    int deleteByPrimaryKey(Integer adviceId);

    int insert(GuideAdvice record);

    int insertSelective(GuideAdvice record);

    List<GuideAdvice> selectByExample(GuideAdviceExample example);

    GuideAdvice selectByPrimaryKey(Integer adviceId);

    int updateByExampleSelective(@Param("record") GuideAdvice record, @Param("example") GuideAdviceExample example);

    int updateByExample(@Param("record") GuideAdvice record, @Param("example") GuideAdviceExample example);

    int updateByPrimaryKeySelective(GuideAdvice record);

    int updateByPrimaryKey(GuideAdvice record);
}