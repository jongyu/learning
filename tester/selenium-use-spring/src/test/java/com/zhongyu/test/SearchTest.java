package com.zhongyu.test;

import com.zhongyu.Application;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(classes = Application.class, loader = AnnotationConfigContextLoader.class)
public class SearchTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebDriver driver;

    @Test
    public void baidu() {
        driver.get("https://www.baidu.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void google(){
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
    }

}
