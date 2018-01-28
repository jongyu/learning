package com.zhongyu.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("/", "index.html")
    fun index(): String {
        return "index"
    }

}