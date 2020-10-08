package com.beyond233.his.service.impl;

import com.beyond233.his.entity.News;
import com.beyond233.his.entity.NewsExample;
import com.beyond233.his.mapper.NewsMapper;
import com.beyond233.his.service.NewsService;
import com.beyond233.his.vo.NewsVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-22 20:17
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public void deleteNewsById(Integer id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<News> findAllNews() {
        NewsExample example = new NewsExample();
        example.createCriteria().andNewsIdIsNotNull();
        return newsMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<NewsVO> findLastNewsCount(Integer count) {
        List<News> newsList = newsMapper.selectLastNewsCount(count);
        List<NewsVO> voList = new ArrayList<>();
        for (News news : newsList) {
            voList.add(findOneNewsVO(news.getNewsId()));
        }
        return voList;
    }

    @Override
    public List<NewsVO> findLastNews(Integer start, Integer count) {
        List<News> newsList = newsMapper.selectLastNews(start, count);
        List<NewsVO> voList = new ArrayList<>();
        for (News news : newsList) {
            voList.add(findOneNewsVO(news.getNewsId()));
        }
        return voList;
    }

    @Override
    public List<NewsVO> findHotNewsVO(int count) {
        List<News> newsList = findNewsWithMaxClicks(count);
        List<NewsVO> voList = new ArrayList<>();
        for (News news : newsList) {
            voList.add(findOneNewsVO(news.getNewsId()));
        }
        return voList;
    }

    @Override
    public NewsVO findOneNewsVO(int newsId) {
        //查询news
        News news = newsMapper.selectByPrimaryKey(newsId);
        //查询图片url
        List<String> urls = newsMapper.selectNewsImgUrlById(newsId);
        return new NewsVO(news, urls);
    }

    @Override
    public List<News> findNewsWithMaxClicks(int count) {
        return newsMapper.selectNewsWithMaxClicks(count);
    }

    @Override
    public List<News> findNewsInOneWeek(Integer count) {
        return newsMapper.selectNewsInOneWork(count);
    }

    @Override
    public List<News> findNewsByKeyword(String keyword, Integer count) {
        return newsMapper.selectNewsByKeyword("%" + keyword + "%", count);
    }

    @Override
    public News findNewsByNewsId(Integer newsId) {
        return newsMapper.selectByPrimaryKey(newsId);
    }

    @Override
    public boolean updateNews(News news) {
        newsMapper.updateByPrimaryKeySelective(news);
        return true;
    }

    @Override
    public boolean deleteNews(List<Integer> ids) {
        newsMapper.deleteNewsByIds(ids);
        return true;
    }

    @Override
    public boolean addNews(News news) {
        newsMapper.insert(news);
        return true;
    }
}
