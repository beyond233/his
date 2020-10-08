package com.beyond233.his.service;

import com.beyond233.his.entity.QA;
import org.apache.logging.slf4j.MDCContextMap;

import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-05-09 22:25
 */
public interface QuestionService {
    /**
     * 通过id查询qa
     *
     * @param id id
     * @return com.beyond233.his.entity.QA
     * @since 2020/5/9 22:38
     */
    QA findQaById(Integer id);

    /**
     * 查询指定数量Qa
     *
     * @param pageNum
     * @param pageSize
     * @param keyWord
     * @return java.util.List<com.beyond233.his.entity.QA>
     * @since 2020/5/9 22:43
     */
    List<QA> findQaLimit(Integer pageNum, Integer pageSize, String keyWord);
}
