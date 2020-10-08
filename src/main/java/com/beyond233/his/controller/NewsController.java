package com.beyond233.his.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.beyond233.his.entity.Department;
import com.beyond233.his.entity.News;
import com.beyond233.his.mapper.NewsMapper;
import com.beyond233.his.service.NewsService;
import com.beyond233.his.vo.NewsVO;
import com.github.pagehelper.PageHelper;
import org.apache.logging.slf4j.MDCContextMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.awt.image.IntegerComponentRaster;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>项目文档: 新闻公告</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 22:10
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    @GetMapping("/page/{newsId}")
    public String toNewsPage(@PathVariable int newsId, Model model) {
        News news = newsService.findNewsByNewsId(newsId);
        //新闻浏览次数+1
        news.setNewsClick(news.getNewsClick() + 1);
        newsService.updateNews(news);
        NewsVO vo = newsService.findOneNewsVO(newsId);
        model.addAttribute("newsVO", vo);
        //查询热点新闻
        List<News> hotNewsList = newsService.findNewsWithMaxClicks(10);
        model.addAttribute("hotNewsList", hotNewsList);
        return "news";
    }

    @GetMapping("/page/home")
    public String toNewsHomePage(Model model, HttpServletRequest request) {
        //查询最近新闻
        List<NewsVO> newsVOList = newsService.findLastNewsCount(9);
        model.addAttribute("newsVOList", newsVOList);

        //清除新闻加载的PageNum
        request.getSession().removeAttribute("pageNum");
        return "newsHome";
    }

    /**
     * 返回分页news
     *
     * @param page  页码
     * @param limit 每页条数
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @since 2020/3/24 22:47
     */
    @ResponseBody
    @GetMapping("/limit")
    public Map<String, Object> returnNewsLimit(int page, int limit) {
        int count = newsService.findAllNews().size();
        PageHelper.startPage(page, limit);
        List<News> allNews = newsService.findAllNews();
        HashMap<String, Object> map = new HashMap<>(20);
        map.put("code", 0);
        map.put("message", "");
        map.put("count", count);
        map.put("data", allNews);
        return map;
    }

    /**
     * 返回对应Id的NewsVO数据
     *
     * @param id 。
     * @return com.beyond233.his.vo.NewsVO
     * @since 2020/5/18 14:37
     */
    @ResponseBody
    @GetMapping("/{id}")
    public NewsVO getOneNews(@PathVariable Integer id) {
        NewsVO newsVO = null;
        if (id != null) {
            newsVO = newsService.findOneNewsVO(id);

            List<String> imgUrl = newsVO.getImgUrl();
            imgUrl.set(0, "/images/" + imgUrl.get(0));
            newsVO.setImgUrl(imgUrl);
        }
        return newsVO;
    }

    /**
     * 返回三条最新的新闻数据
     *
     * @param request 。
     * @return java.util.List<com.beyond233.his.vo.NewsVO>
     * @since 2020/5/18 17:15
     */
    @ResponseBody
    @GetMapping("/more")
    public List<NewsVO> loadMoreNewsVo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer pageNum = (Integer) session.getAttribute("pageNum");
        if (pageNum != null) {
            pageNum += 3;
            session.setAttribute("pageNum", pageNum);
            List<NewsVO> lastNews = newsService.findLastNews(pageNum, 3);
            if (lastNews.size() > 0) {
                return lastNews;
            } else {
                return null;
            }
        } else {
            session.setAttribute("pageNum", 9);
            return newsService.findLastNews(9, 3);
        }
    }

    /**
     * 修改news
     *
     * @param news 前端news数据
     * @param id   id
     * @return java.lang.String
     * @since 2020/3/24 22:56
     */
    @ResponseBody
    @PutMapping("/{id}")
    public String updateNews(@RequestBody News news, @PathVariable int id) {
        try {
            news.setNewsId(id);
            newsService.updateNews(news);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    /**
     * 删除news
     *
     * @param id newsId
     * @return java.lang.String
     * @since 2020/3/24 22:59
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteNews(@PathVariable int id) {
        try {
            newsService.deleteNewsById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    /**
     * 添加新闻
     *
     * @param news 前端传来的news
     * @return java.lang.String
     * @since 2020/3/25 11:19
     */
    @ResponseBody
    @PostMapping("/add")
    public String addNews(News news) {
        try {
            //设置新闻公告时间
            news.setNewsDate(new Date());
            //设置点击数为0
            news.setNewsClick(0);
            //若未设置类型，则默认news
            String newsType = news.getNewsType();
            if (newsType == null || "".equals(newsType)) {
                news.setNewsType("news");
            }
            newsService.addNews(news);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @ResponseBody
    @DeleteMapping("/deleteMore")
    public String deleteMore(int[] ids) {
        try {
            //将int数组转化为list集合
            List<Integer> list = Arrays.stream(ids).boxed().collect(Collectors.toList());
            newsService.deleteNews(list);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }


}
