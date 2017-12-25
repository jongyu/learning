package com.zhongyu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baidu {

    public static void main(String[] args) {
        //TODO:设置驱动路径 可将驱动添加到Path环境下，那样就不用每次都写下面这句话去指定路径了
//        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        driver.findElement(By.name("wd")).sendKeys("钟宇的博客");
        driver.findElement(By.id("su")).click();
    }

}
