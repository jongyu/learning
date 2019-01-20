package com.zhongyu;

import com.zhongyu.business.BaiduBusiness;
import com.zhongyu.handle.BaiduHandle;
import com.zhongyu.page.BaiduPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class Application {

    @Bean(name = "driver", destroyMethod = "close")
    public WebDriver driver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    public BaiduPage baiduPage() {
        return new BaiduPage(driver());
    }

    @Bean
    public BaiduHandle baiduHandle() {
        return new BaiduHandle(baiduPage());
    }

    @Bean
    public BaiduBusiness baiduBusiness() {
        return new BaiduBusiness(baiduHandle());
    }

}
