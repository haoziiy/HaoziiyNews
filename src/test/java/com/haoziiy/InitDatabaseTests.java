package com.haoziiy;

import com.haoziiy.dao.NewsDao;
import com.haoziiy.model.User;
import com.haoziiy.model.News;
import com.haoziiy.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NewsApplication.class)
@Sql("/init-schema.sql")
public class InitDatabaseTests {

	@Autowired
	UserDao userDao;
	@Autowired
	NewsDao newsDao;
	@Test
	public void initData() {

		Random random = new Random();
		for (int i = 0 ;i < 11;i++)
		{
			User user = new User();
			user.setHeadUrl(String.format("https://images.nowcoder.com/%dt.png", random.nextInt(1000)));
			user.setName(String.format("USER%d", i));
			user.setPassword("");
			user.setSalt("");
			userDao.addUser(user);

			News news = new News();
			news.setCommentCount(i);
			Date date = new Date();
			date.setTime(date.getTime() + 1000*3600*5*i);
			news.setCreatedDate(date);
			news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
			news.setLikeCount(i+1);
			news.setUserId(i+1);
			news.setTitle(String.format("TITLE{%d}", i));
			news.setLink(String.format("http://www.nowcoder.com/%d.html", i));
			newsDao.addNews(news);


			user.setPassword("newpasswd");
//			user.setPassword("newpassword");
			userDao.updatePassword(user);
		}
	}

}
