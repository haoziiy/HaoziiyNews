package com.haoziiy.service;

import com.haoziiy.dao.NewsDao;
import com.haoziiy.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sherry on 2017/4/1.
 */
@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public List<News> getLatestNews(int userId, int offset, int limit) {
        return newsDao.selectByUserIdAndOffset(userId, offset, limit);
    }
}

