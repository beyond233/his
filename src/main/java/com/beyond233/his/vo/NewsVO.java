package com.beyond233.his.vo;

import com.beyond233.his.entity.News;

import java.awt.*;
import java.util.List;

/**
 * <p>项目文档: 页面新闻VO</p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-03-24 9:21
 */
public class NewsVO {
    /**
     * 新闻对象
     **/
    private News news;
    /**
     * 图片地址集合
     **/
    private List<String> imgUrl;

    public NewsVO(News news, List<String> imgUrl) {
        this.news = news;
        this.imgUrl = imgUrl;
    }

    public NewsVO() {

    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "NewsVO{" +
                "news=" + news +
                ", imgUrl=" + imgUrl +
                '}';
    }
}
