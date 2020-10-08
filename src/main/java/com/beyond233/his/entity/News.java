package com.beyond233.his.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private Integer newsId;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date newsDate;

    private String newsTitle;

    private String newsAuthor;

    private String newsType;

    private Integer newsClick;

    private String newsArticle;

    private static final long serialVersionUID = 1L;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType == null ? null : newsType.trim();
    }

    public Integer getNewsClick() {
        return newsClick;
    }

    public void setNewsClick(Integer newsClick) {
        this.newsClick = newsClick;
    }

    public String getNewsArticle() {
        return newsArticle;
    }

    public void setNewsArticle(String newsArticle) {
        this.newsArticle = newsArticle == null ? null : newsArticle.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", newsDate=").append(newsDate);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsAuthor=").append(newsAuthor);
        sb.append(", newsType=").append(newsType);
        sb.append(", newsClick=").append(newsClick);
        sb.append(", newsArticle=").append(newsArticle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}