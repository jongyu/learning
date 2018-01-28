package com.zhongyu.controller;

import com.zhongyu.commons.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ZhongYu on 2017/3/5.
 */
@Controller
public class IndexController extends BaseController {

    @GetMapping(value = {"/", "index.html"})
    public String index() {
        logger.info("进入首页");
        return "index";
    }

}
