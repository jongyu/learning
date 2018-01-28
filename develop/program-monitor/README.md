## Program Monitor
定时监测某个程序是否挂掉,如果挂掉执行重启脚本(shell脚本)
### 场景
* 定时检测Hadoop中的Flink程序是否挂掉了
* 由于Flink重启后会生成新的applicationId所以不能直接监测Flink页面,所有用笨办法解决问题
* 直接从Hadoop中爬取页面包含自己的任务id如果没有就是挂掉

### FAQ
* Java可以直接调Groovy
* 定时任务使用的是SpringBoot自带的

