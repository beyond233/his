package com.beyond233.his.service.impl;

import com.beyond233.his.entity.Drug;
import com.beyond233.his.entity.DrugExample;
import com.beyond233.his.mapper.DrugMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: 药品业务</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-15 23:32
 */
@Service
public class DrugServiceImpl {
    @Resource
    DrugMapper drugMapper;


    /**
     * 通过id获取对应药品
     **/
    public Drug findDrugById(int drugId) {
        return drugMapper.selectByPrimaryKey(drugId);
    }

    /**
     * 获取所有药品
     **/
    public List<Drug> findAllDrug() {
        DrugExample example = new DrugExample();
        example.createCriteria().andDrugIdIsNotNull();
        return drugMapper.selectByExample(example);
    }

    /**
     * 添加药品
     **/
    public void addDrug(Drug drug) {
        drugMapper.insert(drug);
    }

    /**
     * 删除药品
     **/
    public void deleteDrug(int drugId) {
        drugMapper.deleteByPrimaryKey(drugId);
    }

    /**
     * 修改药品
     **/
    public void updateDrug(Drug drug) {
        drugMapper.updateByPrimaryKeySelective(drug);
    }

}
