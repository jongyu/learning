package com.zhongyu.handle;

import com.zhongyu.page.BaiduPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaiduHandle {

    private final BaiduPage baiduPage;

    @Autowired
    public BaiduHandle(BaiduPage baiduPage) {
        this.baiduPage = baiduPage;
    }

    public void send(String context) {
        baiduPage.input().sendKeys(context);
    }

    public void clickSubmit() {
        baiduPage.button().click();
    }

}
