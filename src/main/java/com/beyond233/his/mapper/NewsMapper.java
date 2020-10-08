package com.beyond233.his.mapper;

import com.beyond233.his.entity.News;
import com.beyond233.his.entity.NewsExample;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author BEYOND
 */
@Mapper
public interface NewsMapper {
    /**
     * 查询前多少条最新的新闻数据
     *
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/5/18 16:39
     */
    List<News> selectLastNewsCount(Integer count);

    /**
     * 查询最新的新闻数据
     *
     * @param start 查询起点
     * @param count 查询数量
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/5/18 17:18
     */
    List<News> selectLastNews(Integer start, Integer count);

    /**
     * 封装点击数最高的新闻数据,指定查询多少条
     *
     * @param count 指定条数
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/22 20:04
     */
    List<News> selectNewsWithMaxClicks(Integer count);

    /**
     * 封装一周内的新闻
     *
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/22 20:09
     */
    List<News> selectNewsInOneWork(Integer count);

    /**
     * 通过关键词来搜索新闻
     *
     * @param keyword 关键词
     * @return java.util.List<com.beyond233.his.entity.News>
     * @since 2020/3/22 20:16
     */
    List<News> selectNewsByKeyword(String keyword, Integer count);

    /**
     * 删除多条新闻
     *
     * @param ids id集合
     * @return void
     * @since 2020/3/22 22:49
     */
    void deleteNewsByIds(List<Integer> ids);

    /**
     * 通过id查询新闻对应的全部图片url
     *
     * @param newsId 新闻id
     * @return java.util.List<java.lang.String>
     * @since 2020/3/24 9:42
     */
    List<String> selectNewsImgUrlById(int newsId);


    long countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExampleWithBLOBs(NewsExample example);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Integer newsId);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExampleWithBLOBs(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}