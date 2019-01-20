package com.zhongyu.business;

import com.zhongyu.handle.BaiduHandle;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class BaiduBusiness {

    private final BaiduHandle baiduHandle;

    @Autowired
    private WebDriver driver;

    @Autowired
    public BaiduBusiness(BaiduHandle baiduHandle) {
        this.baiduHandle = baiduHandle;
    }

    public void search() {
        baiduHandle.send("Yu's Blog");
        baiduHandle.clickSubmit();
        try {
            Thread.sleep(2000);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("/Users/zhongyu/Downloads/screenshot.png"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
