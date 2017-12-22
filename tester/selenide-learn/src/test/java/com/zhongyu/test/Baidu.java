package com.zhongyu.test;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class Baidu {

    @Test
    public void search() {
        Configuration.browser = "chrome";
        open("https://www.baidu.com");
    }

}
