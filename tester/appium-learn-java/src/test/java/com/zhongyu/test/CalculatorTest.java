package com.zhongyu.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    private Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testPlus() {
        driver.findElementById("digit_4").click();
        driver.findElementByAccessibilityId("加").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("eq").click();
        String result = driver.findElement(By.id("formula")).getText();
        logger.info("4 + 9 = " + result);
        Assert.assertEquals(result, "13");
    }

    @Test
    public void testCut() {
        driver.findElement(By.id("digit_8")).click();
        driver.findElementById("op_sub").click();
        driver.findElementById("digit_6").click();
        driver.findElementById("eq").click();
        String result = driver.findElement(By.id("formula")).getText();
        logger.info("8 + 6 = " + result);
        Assert.assertEquals(result, "2");
    }

    @Test
    public void testMultiply() {
        driver.findElement(By.id("digit_3")).click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_7").click();
        driver.findElementById("eq").click();
        String result = driver.findElement(By.id("formula")).getText();
        logger.info("3 * 7 = " + result);
        Assert.assertEquals(result, "21");
    }

    @Test
    public void testDivided() {
        driver.findElement(By.id("digit_8")).click();
        driver.findElementById("op_div").click();
        driver.findElementById("digit_2").click();
        driver.findElementById("eq").click();
        String result = driver.findElement(By.id("formula")).getText();
        logger.info("8 / 2 = " + result);
        Assert.assertEquals(result, "4");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(100);
        driver.quit();
    }

}
