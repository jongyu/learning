package com.zhongyu.example

import com.zhongyu.util.ExecuteScript
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
/**
 * Created by ZhongYu on 19/08/2017.
 */
@Component
class Scheduler {

    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class)

    @Scheduled(cron = '0 */5 * * * *')
    void monitorFlink() {
        boolean isFail = monitor()
        logger.info("Perform timed tasks")
        if (isFail == false) {
            //判断程序是否挂掉,如果挂掉了执行脚本从新运行
            logger.info("The restart script is being executed")
            ExecuteScript.execute '/Users/zhongyu/GitHub/ProgramMonitor/src/main/resources/script.sh '
        }
    }

    static boolean monitor() {
        boolean result = false
        try {
            Document document = Jsoup.connect("https://zhongyu.biz").get()
            Elements elements = document.getElementsByTag("script")
            //判断从网页中抓取回来的内容是否包含自己的任务名字
            result = elements.html().contains("StreamingJob")
        } catch (IOException e) {
            logger.error("No task found")
        }
        return result
    }

}
