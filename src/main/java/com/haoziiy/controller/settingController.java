package com.haoziiy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sherry on 2017/3/30.
 */
@Controller
public class settingController {
    @RequestMapping(value = {"/setting"})
    @ResponseBody
    public String setting(){
        return "Setting : OK";
    }
}
