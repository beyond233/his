package com.beyond233.his.mapper;

import com.beyond233.his.entity.GuideSymptom;
import com.beyond233.his.entity.GuideSymptomExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GuideSymptomMapper {
    long countByExample(GuideSymptomExample example);

    int deleteByExample(GuideSymptomExample example);

    int deleteByPrimaryKey(@Param("symptomId") Integer symptomId, @Param("symptomName") String symptomName);

    int insert(GuideSymptom record);

    int insertSelective(GuideSymptom record);

    List<GuideSymptom> selectByExample(GuideSymptomExample example);

    GuideSymptom selectByPrimaryKey(@Param("symptomId") Integer symptomId, @Param("symptomName") String symptomName);

    int updateByExampleSelective(@Param("record") GuideSymptom record, @Param("example") GuideSymptomExample example);

    int updateByExample(@Param("record") GuideSymptom record, @Param("example") GuideSymptomExample example);

    int updateByPrimaryKeySelective(GuideSymptom record);

    int updateByPrimaryKey(GuideSymptom record);
}