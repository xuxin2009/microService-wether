package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2019/6/13.
 */
@Controller
public class UserController {
    @RequestMapping(value = "user")
    public String success(Map<String, Object> paramMap) {
        /** 默认Map的内容会放大请求域中，页面可以直接取值*/
        paramMap.put("name", "zhangSan");
        paramMap.put("age", 28);

        /** 会自动跳转到默认的 classpath:/templates/success.html 页面*/
        return "index";
    }

}
