package com.zhongyu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class ParserFile {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        File html = new File(path + "\\src\\main\\resources\\html\\index.html");
        Document doc = Jsoup.parse(html, "UTF-8", "http://example.com/");
        System.out.println(doc.title());
    }

}
