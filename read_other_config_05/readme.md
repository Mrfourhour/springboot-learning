# springboot获取其他配置文件的内容

***创建springboot项目,然后获取除全局配置文件之外的其他配置文件***

## 1. 获取单个 xxx.properties 配置文件内容
 *在resources目录下创建student.properties 文件,文件内容如下所示*
```yaml
student.name = zhangsan
student.age = 24
student.gender = 男
```
 *创建student实体类,如下所示*
```java
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
```
 *在主配置类上加上注解@PropertySource, 如下*
```java
@PropertySource(value = "classpath:student.properties")
@SpringBootApplication
public class ReadOtherConfig05Application {
    public static void main(String[] args) {
        SpringApplication.run(ReadOtherConfig05Application.class, args);
    }
}
```
 *编写测试类, 如下*
```java
@SpringBootTest
class ReadOtherConfig05ApplicationTests {
    @Autowired
    private Student student;
    @Test
    void contextLoads() {
        System.out.println(student);
    }
}
```
 *输出结果为: Student{name='zhangsan', age=24, gender='男'}*
## 2. 获取多个 xxx.properties 配置文件内容
 *再创建另外一个user.properties文件,操作步骤同1,不同的在于主类上, 如下,两种引入方式，二者取其一*
```java
@PropertySources({@PropertySource("classpath:student.properties"),
        @PropertySource("classpath:user.properties")})
//@PropertySource(value = "classpath:student.properties")
//@PropertySource(value = "classpath:user.properties")
@SpringBootApplication
public class ReadOtherConfig05Application {
    public static void main(String[] args) {
        SpringApplication.run(ReadOtherConfig05Application.class, args);
    }
}
```
## 3. 获取单个 xxx.yml 配置文件的内容
 *在resource目录下新建player.yml配置文件,其内容如下*
```yaml
player:
  playerId: 007
  playerName: 关忆北
  account: admin
  password: 123456
```
 *实体类内容如下*
```java
@Component
@ConfigurationProperties(prefix = "player")
public class Player {
    private String playerId;
    private String playerName;
    private String account;
    private String password;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```
 *需要用到DefaultPropertySourceFactory, 创建一个类实现DefaultPropertySourceFactory,并重写createPropertySource方法, 如下*
```java
/**
 * @author Administrator
 * @description //用于加载 xxx.yml配置文件内容
 * @date 2020/6/29 10:57
 */
public class PropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (Objects.isNull(resource)) return super.createPropertySource(name, resource);
        List<PropertySource<?>> propertySources = new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource());
        return propertySources.get(0);
    }
}
```

 *启动类如下*
```java
@PropertySource(value = "classpath:player.yml", factory = PropertySourceFactory.class)
@SpringBootApplication
public class ReadOtherConfig05Application {
    public static void main(String[] args) {
        SpringApplication.run(ReadOtherConfig05Application.class, args);
    }
}
```
## 4. 获取多个 xxx.yml 配置文件的内容
 *新建另外一个xxx.yml文件, 配置同3, 主启动类如下*
```java
@PropertySources({
        @PropertySource(value = "classpath:player.yml", factory = PropertySourceFactory.class),
        @PropertySource(value = "classpath:player2.yml", factory = PropertySourceFactory.class)})
@SpringBootApplication
public class ReadOtherConfig05Application {
    public static void main(String[] args) {
        SpringApplication.run(ReadOtherConfig05Application.class, args);
    }
}
```