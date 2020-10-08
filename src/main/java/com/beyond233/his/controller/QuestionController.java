package com.beyond233.his.controller;

import com.beyond233.his.entity.QA;
import com.beyond233.his.service.QuestionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: 常见问题</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-17 16:32
 */
@Controller
@RequestMapping("/qa")
public class QuestionController {

    @Resource
    private QuestionService qaService;

    /**
     * 访问常见问题页面
     **/
    @GetMapping("/page")
    public String toQuestionPage(Model model) {
        //分类查询常见问题
        //1.门诊预约
        List<QA> zmyyList = qaService.findQaLimit(1, 5, "门诊");
        model.addAttribute("zmyyList", zmyyList);
        //2.就诊指南
        List<QA> jzznList = qaService.findQaLimit(1, 5, "就诊");
        model.addAttribute("jzznList", jzznList);
        //3.医疗检查
        List<QA> yljcList = qaService.findQaLimit(1, 5, "检查");
        model.addAttribute("yljcList", yljcList);
        //4.事务办理
        List<QA> swblList = qaService.findQaLimit(1, 5, "办理");
        model.addAttribute("swblList", swblList);

        return "question";
    }

    /**
     * 返回对应id的问题的Json数据
     */
    @ResponseBody
    @GetMapping("/{id}")
    public QA returnOneQa(@PathVariable Integer id) {
        return qaService.findQaById(id);
    }
}
