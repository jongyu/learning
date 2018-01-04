package com.zhongyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping({"/", "index.html"})
    public String index() {
        return "index";
    }

    @GetMapping("message")
    @ResponseBody
    public Object message() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Hello World!");
        return result;
    }
}
