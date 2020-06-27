# helloworld
## 1.create project by spring initializr
   由于创建的是maven的springboot项目，已经导入了springboot项目的父依赖以及maven的相关依赖
```xml
<!--springboot项目的父依赖-->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.1.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
<!--springboot项目的测试依赖-->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
        <exclusions>
            <exclusion>
                <groupId>org.junit.vintage</groupId>
                <artifactId>junit-vintage-engine</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
<!--maven插件依赖-->
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
## 2.add web model
```xml
<!--这是springboot应用的web依赖模块（web启动器）-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
## 3. 创建controller来测试springboot应用
   在程序自动生成的主程序同级目录下，创建一个controller包，以及编写一个controller类来测试spring boot应用
```java
@Controller /*声明这是个controller并将其托管给spring */
public class TestController {

    @ResponseBody/*@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，通常用来返回JSON数据或者是XML数据。*/
    @RequestMapping("/hello")/*请求路径*/
    public String hello(){
        return "hello springboot";
    }
}
```
    启动应用，访问对应的路径即可获取到 hello springboot，，，测试通过
## 4.将springboot应用打包成可运行的jar
 通过maven插件的lifecycle 下面的package可以将spring boot项目打包成可执行的jar文件，
 并且可以直接通过   ‘Java -jar jar包名’  来执行

## 5.pom.xml文件详解
  pom文件中的parent是springboot项目的父依赖
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.1.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```
 parent的父依赖是spring-boot-dependencies
 ```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.3.1.RELEASE</version>
</parent>
```
  spring-boot-dependencies管理了各个启动器starter的版本,是版本冲裁中心，
  没有被其管理的依赖，需要自己声明其版本信息
 ```xml
<properties>
    <activemq.version>5.15.12</activemq.version>
    <antlr2.version>2.7.7</antlr2.version>
    <appengine-sdk.version>1.9.80</appengine-sdk.version>
    <artemis.version>2.12.0</artemis.version>
    <aspectj.version>1.9.5</aspectj.version>
    <assertj.version>3.16.1</assertj.version>
    <atomikos.version>4.0.6</atomikos.version>
    ...
  </properties>
```
  引入依赖: 通过引入各个场景的starter来引入依赖，比如 web 场景的依赖如下
 ```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
 ```
 每个starter场景，包含了每个模块正常运行所需要的依赖