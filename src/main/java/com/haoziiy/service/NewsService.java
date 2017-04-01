package com.haoziiy.service;

import com.haoziiy.dao.NewsDao;
import com.haoziiy.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sherry on 2017/4/1.
 */
@Service
public class NewsService {
    private NewsDao newsDao;
    public List<News> getLastestNews(int userId, int offset, int limit){
        return newsDao.selectByUserIdAndOffset(userId, offset, limit);
    }
}
