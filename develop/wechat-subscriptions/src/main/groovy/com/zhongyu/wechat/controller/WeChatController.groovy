package com.zhongyu.wechat.controller

import com.zhongyu.wechat.aes.SHA1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("wechat")
class WeChatController {

    @GetMapping("security")
    def doGet(@RequestParam String signature,
              @RequestParam String timestamp,
              @RequestParam String nonce,
              @RequestParam String echostr) {
        def message = [:]
        String isTrue = SHA1.getSHA1("zhongyua", timestamp, nonce, "")
        if (isTrue == signature) {
            return echostr
        } else {
            return message
        }
    }

}
