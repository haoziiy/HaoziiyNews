package com.haoziiy.controller;

import com.haoziiy.model.User;
import com.haoziiy.service.NewsService;
import com.haoziiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherry on 2017/4/1.
 */
@Controller
public class HomeController {
    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String index(HttpSession session){
        return "home";
    }

    @RequestMapping(value = {"/vm"})
    public String news(Model model){
        model.addAttribute("value1", "vv1");
        List<String> colors = Arrays.asList(new String[]{"RED", "GREEN", "BLUE"});
        Map<String, String> map = new HashMap<>();
        for (int i = 0;i < 4;i++)
        {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }
        model.addAttribute("colors", colors);
        model.addAttribute("map", map);
        model.addAttribute("user", new User("Alice"));
        return "news";
    }

}
