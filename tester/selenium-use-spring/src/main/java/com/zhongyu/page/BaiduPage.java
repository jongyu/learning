package com.zhongyu.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaiduPage {

    private final WebDriver driver;

    @Autowired
    public BaiduPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement input() {
        return driver.findElement(By.name("wd"));
    }

    public WebElement button(){
        return driver.findElement(By.id("su"));
    }

}
