## SpringBootStudy
* 使用IntelliJ IDEA构建项目

### 配置
* application.properties 重复语句多
* application.yml 更简便

### IDEA实现热部署
1.在项目pom文件中导入依赖
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>
```

2.Ctrl + Shift + A 查找`make project automatically`并选中

3.Ctrl + Shift + A 查找`Registry`找到`compiler.automake.allow.when.app.running`

### 多环境
* 以生产环境运行
```
java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar --spring.profiles.active=produce
```
* 以开发环境运行
```
java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar --spring.profiles.active=develop
```
