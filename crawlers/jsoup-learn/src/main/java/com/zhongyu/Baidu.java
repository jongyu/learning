package com.zhongyu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Baidu {

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.baidu.com/").get();
        System.out.println(document.title());
    }

}
