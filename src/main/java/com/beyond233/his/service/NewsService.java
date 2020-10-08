package com.beyond233.his.service;

import com.beyond233.his.entity.News;
import com.beyond233.his.vo.NewsVO;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.List;
import java.util.Set;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 20:00
 */
public interface NewsService {
    /**
     * 按照时间降序查询指定数量新闻数据
     *
     * @param count 。
     * @return java.util.List<com.beyond233.his.vo.NewsVO>
     * @since 2020/5/18 17:01
     */
    List<NewsVO> findLastNewsCount(Integer count);

    /**
     * 按照时间降序从九条起分页查询指定数量新闻数据
     *
     * @param start 查询起点
     * @param count 查询数量
     * @return java.util.List<com.beyond233.his.vo.NewsVO>
     * @since 2020/5/18 17:00
     */
    List<NewsVO> findLastNews(Integer start, Integer count);

    /**
     * 查询指定数量的点击数最高的新闻，返回newsVO集合
     *
     * @param count 指定查询条数
     * @return java.util.List<com.beyond233.his.vo.NewsVO>
     * @since 2020/3/24 9:50
     */
    List<NewsVO> findHotNewsVO(int count);

    /**
     * 查询对应id的新闻VO
     *
     * @param newsId id
     * @return com.beyond233.his.vo.NewsVO
     * @since 2020/3/24 9:43
     */
    NewsVO findOneNewsVO(int newsId);

    /**
     * 封装点击数最高的新闻数据 ，指定查询多少条
     *
     * @param count 指定查询条数
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/24 9:45
     */
    List<News> findNewsWithMaxClicks(int count);

    /**
     * 封装一周内的新闻
     *
     * @param count 条数
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/22 20:09
     */
    List<News> findNewsInOneWeek(Integer count);

    /**
     * 通过关键词来搜索新闻
     *
     * @param keyword 关键词
     * @param count   查询条数
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/22 20:16
     */
    List<News> findNewsByKeyword(String keyword, Integer count);

    /**
     * 查询
     *
     * @param newsId 。
     * @return com.beyond233.his.entity.News
     * @since 2020/3/22 22:24
     */
    News findNewsByNewsId(Integer newsId);

    /**
     * 修改
     *
     * @param news .
     * @return void
     * @since 2020/3/22 22:25
     */
    boolean updateNews(News news);

    /**
     * 删除多条
     *
     * @param ids id集合
     * @return void
     * @since 2020/3/22 22:26
     */
    boolean deleteNews(List<Integer> ids);

    /**
     * 添加
     *
     * @param news 。
     * @return void
     * @since 2020/3/22 22:28
     */
    boolean addNews(News news);

    /**
     * 查询全部news
     *
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/24 22:49
     */
    List<News> findAllNews();

    /**
     * 通过id删除news
     *
     * @param id .
     * @return void
     * @since 2020/3/24 23:01
     */
    void deleteNewsById(Integer id);

}
