package com.beyond233.his.mapper;

import com.beyond233.his.entity.GuideBodyPart;
import com.beyond233.his.entity.GuideBodyPartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GuideBodyPartMapper {
    long countByExample(GuideBodyPartExample example);

    int deleteByExample(GuideBodyPartExample example);

    int deleteByPrimaryKey(Integer bodypartId);

    int insert(GuideBodyPart record);

    int insertSelective(GuideBodyPart record);

    List<GuideBodyPart> selectByExample(GuideBodyPartExample example);

    GuideBodyPart selectByPrimaryKey(Integer bodypartId);

    int updateByExampleSelective(@Param("record") GuideBodyPart record, @Param("example") GuideBodyPartExample example);

    int updateByExample(@Param("record") GuideBodyPart record, @Param("example") GuideBodyPartExample example);

    int updateByPrimaryKeySelective(GuideBodyPart record);

    int updateByPrimaryKey(GuideBodyPart record);
}