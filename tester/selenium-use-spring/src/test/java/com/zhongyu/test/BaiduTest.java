package com.zhongyu.test;

import com.zhongyu.Application;
import com.zhongyu.business.BaiduBusiness;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(classes = Application.class, loader = AnnotationConfigContextLoader.class)
public class BaiduTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BaiduBusiness baiduBusiness;
    @Autowired
    private WebDriver driver;

    @Test
    public void searchTest(){
        driver.get("https://www.baidu.com");
        baiduBusiness.search();
    }

}
