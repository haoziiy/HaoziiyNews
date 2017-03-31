package com.haoziiy.service;

import com.haoziiy.dao.UserDao;
import com.haoziiy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sherry on 2017/3/31.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(int id){
        return userDao.selectById(id);
    }

}
