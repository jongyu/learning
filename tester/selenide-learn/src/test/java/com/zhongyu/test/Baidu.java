package com.zhongyu.test;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class Baidu {

    @Test
    public void search() {
        Configuration.browser = "chrome";
        open("https://www.baidu.com");
        $(By.name("wd")).sendKeys("钟宇的博客");
        $(By.id("su")).sendKeys(Keys.ENTER);
        $(By.partialLinkText("zhongyu.biz")).click();
        switchTo().window("ZhongYuOwO");
        $(By.partialLinkText("路线图")).click();
        sleep(5000);
    }

}
