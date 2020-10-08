package com.beyond233.his.mapper;

import com.beyond233.his.entity.GuideQuestion;
import com.beyond233.his.entity.GuideQuestionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GuideQuestionMapper {
    long countByExample(GuideQuestionExample example);

    int deleteByExample(GuideQuestionExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(GuideQuestion record);

    int insertSelective(GuideQuestion record);

    List<GuideQuestion> selectByExample(GuideQuestionExample example);

    GuideQuestion selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") GuideQuestion record, @Param("example") GuideQuestionExample example);

    int updateByExample(@Param("record") GuideQuestion record, @Param("example") GuideQuestionExample example);

    int updateByPrimaryKeySelective(GuideQuestion record);

    int updateByPrimaryKey(GuideQuestion record);
}