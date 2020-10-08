package com.beyond233.his.mapper;

import com.beyond233.his.entity.QA;
import com.beyond233.his.entity.QAExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QAMapper {
    List<QA> selectQaLikeKeyWord(String keyWord);

    long countByExample(QAExample example);

    int deleteByExample(QAExample example);

    int deleteByPrimaryKey(Integer qaId);

    int insert(QA record);

    int insertSelective(QA record);

    List<QA> selectByExampleWithBLOBs(QAExample example);

    List<QA> selectByExample(QAExample example);

    QA selectByPrimaryKey(Integer qaId);

    int updateByExampleSelective(@Param("record") QA record, @Param("example") QAExample example);

    int updateByExampleWithBLOBs(@Param("record") QA record, @Param("example") QAExample example);

    int updateByExample(@Param("record") QA record, @Param("example") QAExample example);

    int updateByPrimaryKeySelective(QA record);

    int updateByPrimaryKeyWithBLOBs(QA record);

    int updateByPrimaryKey(QA record);
}