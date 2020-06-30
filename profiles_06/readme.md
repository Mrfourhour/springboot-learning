# 关于多配置文件的切换

## 1. springboot的默认配置文件
   新建一个springboot项目，在类路径下会自动生成一个application.properties 文件  
   将程序运行端口配置为8090，配置文件的内容如下   
```yaml
server.port=8090
```
   启动项目，可以看到项目已经成功的部署到8090端口   
   
   ---
   此时若我们在类路径下新建application.yml文件，并将服务端口配置成9090   
   在两个文件并存的情况下，启动项目可以发现: 项目最终在端口8090下部署成功   
## 2. 多文件配置
  ### 2.1 我们在主配置文件编写的时候，文件名可以是 application-xxx.properties/yml   例如：
  - application-dev.yml
  - application-at.yml
  - application-b1.yml   
  ### 2，2 选择激活要用的配置文件   
  #### 2.2.1 配置文件中激活
  application.yml的内容如下  
```yaml
server:
  port: 8080
spring:
  profiles:
    active: dev  #选择激活application-dev.yml配置文件
``` 
  application-b1.yml的内容如下   
  ```yaml
server:
  port: 8082
```
  application-at.yml的内容如下   
 ```yaml
server:
  port: 8083
```
  application-dev.yml的内容如下   
 ```yaml
server:
  port: 8081
```
  启动项目可以发现，项目最终启动的端口是8081
  #### 2.2.2 命令行激活
  java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev   
  
  也可以在idea在Edit configurations... 中配置active profiles(2020版idea)   
  也可以在program arguments 中配置 --spring.profiles.active=dev
  #### 2.2.3 虚拟机参数激活
  在VM options 中配置 -Dspring.profiles.active=dev

## 3. yml多文档块
```yaml

server:
  port: 8080
spring:
  profiles:
    active: b1 #指定激活的配置文件

---
server:
  port: 8081
spring:
  profiles: dev
---

server:
  port: 8082
spring:
  profiles: b1

---
server:
  port: 8083
spring:
  profiles: at
```
  启动项目，可以发现项目在8082端口下部署成功。