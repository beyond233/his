package com.beyond233.his.service.impl;

import com.beyond233.his.entity.EmployeeExample;
import com.beyond233.his.entity.QA;
import com.beyond233.his.entity.QAExample;
import com.beyond233.his.mapper.QAMapper;
import com.beyond233.his.service.QuestionService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-05-09 22:26
 */

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    QAMapper qaMapper;


    @Override
    public QA findQaById(Integer id) {
        if (id != null) {
            return qaMapper.selectByPrimaryKey(id);
        }
        return null;
    }


    @Override
    public List<QA> findQaLimit(Integer pageNum, Integer pageSize, String keyWord) {
        if (pageNum != null && pageSize != null && keyWord != null && !"".equals(keyWord)) {
            QAExample example = new QAExample();
            example.createCriteria().andQaQLike("%" + keyWord + "%");
            PageHelper.startPage(pageNum, pageSize);
            return qaMapper.selectByExample(example);
        }
        return null;
    }
}
