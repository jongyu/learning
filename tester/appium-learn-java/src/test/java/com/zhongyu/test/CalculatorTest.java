package com.zhongyu.test;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseDriver {

    private Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

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
