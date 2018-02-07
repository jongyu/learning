package com.zhongyu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

public class Kid17 {

    private static Logger logger = LoggerFactory.getLogger(Kid17.class);

    public static String login(String phone, String password) {
        WebDriver driver = new ChromeDriver();
        final String url = "http://rc.kid17.com";
        driver.get(url);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
        StringBuffer buffer = new StringBuffer();
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            buffer.append(cookie.getName() + "=" + cookie.getValue() + "; ");
        }
        logger.info(buffer.toString());
        driver.quit();
        return buffer.toString();
    }

    public static Document request(String host, String cookie, String url) {
        Connection.Response html = null;
        try {
            html = Jsoup.connect(url)
                    .cookie("Cookie", cookie)
                    .header("Host", host)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Connection", "keep-alive")
                    .header("Content-Type", "text/html;charset=utf-8")
                    .header("Cache-Control", "max-age=0")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "zh,en;q=0.9")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36")
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return html.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String cookie = login("17621253507", "123456");
        Document html = request("rc.kid17.com", cookie, "http://rc.kid17.com/index.php?s=/Home/weibo/getlist_v2&page=0&ismine=9");
        JSONObject raw = JSONObject.parseObject(html.text());
        JSONArray array = raw.getJSONArray("data");
        for (int i = 0; i < array.size(); i++) {
            JSONObject json = array.getJSONObject(i);
            System.out.println("创建时间：" + json.get("create_time"));
            System.out.println("标题：" + json.get("title"));
            System.out.println("内容：" + json.get("content"));

        }
    }

}
