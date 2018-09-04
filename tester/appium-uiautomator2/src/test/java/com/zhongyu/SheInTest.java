package com.zhongyu;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhongYu
 */
public class SheInTest {

    public AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "da11cabb");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zzkko");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".bussiness.login.ui.WelcomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() {
        driver.findElementById("tv_skip").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        driver.findElementById("imageView").click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.support.v7.app.ActionBar$Tab\").instance(0)")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.zzkko:id/email_edt\")")).sendKeys("zhongyu@gmail.com");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.zzkko:id/pwdEdtTxt\")")).sendKeys("Shein1235");
        driver.findElementById("login_or_register_button").click();
        String xpath = "//*[@class='android.widget.Toast']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText());
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }

}
