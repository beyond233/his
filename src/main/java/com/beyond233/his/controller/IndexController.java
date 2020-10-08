package com.beyond233.his.controller;

import com.beyond233.his.entity.News;
import com.beyond233.his.mapper.NewsMapper;
import com.beyond233.his.service.NewsService;
import com.beyond233.his.vo.NewsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目文档: 首页</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-21 19:47
 */
@Controller
public class IndexController {
    @Resource
    NewsService service;

    @GetMapping({"/", "/index", "/index.html"})
    public String toIndexPage(Model model) {
        //封装新闻数据
        List<News> hotNewsList = service.findNewsWithMaxClicks(5);
        //查询疫情新闻
        List<News> illNewsList = service.findNewsByKeyword("疫情", 5);
        //封装公告数据
        List<NewsVO> newsVOList = service.findHotNewsVO(6);
        model.addAttribute("newsVOList", newsVOList);
        model.addAttribute("hotNewsList", hotNewsList);
        model.addAttribute("illNewsList", illNewsList);
        return "index";
    }

}
