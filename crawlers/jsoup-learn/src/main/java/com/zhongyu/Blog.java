package com.zhongyu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Blog {

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://zhongyu.ren").get();
        //当前网页中的标题
        System.out.println(document.title());
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        //得到网页中的所有为h1的标题
        Elements titles = document.getElementById("posts").select("h1");
        for (Element title : titles) {
            System.out.println(title.text());
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        Elements second = document.select(".post-body h5");
        for (Element element : second) {
            System.out.println(element.text());
        }
    }

}
