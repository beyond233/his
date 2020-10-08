package com.beyond233.his.mapper;

import com.beyond233.his.entity.Register;
import com.beyond233.his.entity.RegisterExample;

import java.util.List;

import com.beyond233.his.vo.ExpertRegisterRecord;
import org.apache.ibatis.annotations.Param;

public interface RegisterMapper {
    /**
     * -查询某一科室的全部挂号排班信息
     **/
    List<ExpertRegisterRecord> selectAllRegistersByDepartId(Integer departmentId);

    /**
     * 查询专家出诊信息
     **/
    List<ExpertRegisterRecord> selectAllExpertRegister();

    long countByExample(RegisterExample example);

    int deleteByExample(RegisterExample example);

    int deleteByPrimaryKey(Integer registerId);

    int insert(Register record);

    int insertSelective(Register record);

    List<Register> selectByExample(RegisterExample example);

    Register selectByPrimaryKey(Integer registerId);

    int updateByExampleSelective(@Param("record") Register record, @Param("example") RegisterExample example);

    int updateByExample(@Param("record") Register record, @Param("example") RegisterExample example);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}