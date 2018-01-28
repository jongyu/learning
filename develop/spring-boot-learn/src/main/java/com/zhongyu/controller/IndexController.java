package com.zhongyu.controller;

import com.zhongyu.config.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhongYu on 3/12/2017.
 */
@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${constants}")
    private String constants;

    @Autowired
    private ConfigProperties configProperties;

    @ResponseBody
    @GetMapping("config")
    public String config() {
        return configProperties.getNickname();
    }

    @ResponseBody
    @GetMapping("con")
    public String token() {
        return constants;
    }

    @GetMapping({"/", "index.html"})
    public String index() {
        return "index";
    }

}
