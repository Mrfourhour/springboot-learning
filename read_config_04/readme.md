# springboot读取配置文件(.yml)

## 1.读取方式一 @Value("${XXX}")
```yaml
student:
  name: zhangsan
  age: 24
  gender: 男
```
```java
@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private int age;
    @Value("${student.gender}")
    private String gender;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

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
}
```
```java
@SpringBootTest
class ReadConfigApplicationTests {
    @Autowired
    private Student student;
    @Test
    void contextLoads() {
        System.out.println(student);
    }
}
```
输出：Student{name='zhangsan', age=24, gender='男'}

## 2.读取方式二  @ConfigurationProperties(prefix = "XXX")
```yaml
config-attributes:
  value: 'this is a \n string value'       #对应单个值
  valueArray: 1,2,3,4,5,6,7,8,9            #对应数组,[]可以省略
  valueList:                               #对应list
    - 13579
    - 246810
  valueMap:                                #对应map<String, String>
    name: lili
    age: 20
    sex: female
  valueMapList:                            #对应list<map<String, String>>
    - name: bob
      age: 21
    - name: caven
      age: 31
```
```java
/**
* 配置类
*/
@Component
@ConfigurationProperties(prefix = "config-attributes")
public class Config {
    private String value;
    private String[] valueArray;
    private List<String> valueList;
    private HashMap<String, String> valueMap;
    private List<Map<String, String>> valueMapList;


    @Override
    public String toString() {
        return "Config{" +
                "value='" + value + '\'' +
                ", valueArray=" + Arrays.toString(valueArray) +
                ", valueList=" + valueList +
                ", valueMap=" + valueMap +
                ", valueMapList=" + valueMapList +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getValueArray() {
        return valueArray;
    }

    public void setValueArray(String[] valueArray) {
        this.valueArray = valueArray;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public HashMap<String, String> getValueMap() {
        return valueMap;
    }

    public void setValueMap(HashMap<String, String> valueMap) {
        this.valueMap = valueMap;
    }

    public List<Map<String, String>> getValueMapList() {
        return valueMapList;
    }

    public void setValueMapList(List<Map<String, String>> valueMapList) {
        this.valueMapList = valueMapList;
    }
}
```
```java
/**
* 测试类
*/
@SpringBootTest
class ReadConfigApplicationTests {
    @Autowired
    private Config config;
    @Test
    void contextLoads() {
        System.out.println(config);
    }
}
```
输出： Config{value='this is a \n string value', valueArray=[1, 2, 3, 4, 5, 6, 7, 8, 9], valueList=[13579, 246810], valueMap={name=lili, age=20, sex=female}, valueMapList=[{name=bob, age=21}, {name=caven, age=31}]}
    Student{name='zhangsan', age=24, gender='男'}
    
当将yml中的 value: 'this is a \n string value'  改为 value: "this is a \n string value" 
输出： Config{value='this is a 
     string value', valueArray=[1, 2, 3, 4, 5, 6, 7, 8, 9], valueList=[13579, 246810], valueMap={name=lili, age=20, sex=female}, valueMapList=[{name=bob, age=21}, {name=caven, age=31}]}
    Student{name='zhangsan', age=24, gender='男'}
备注： 单引号转义,双引号不转义
## 3.总结 
其他版本说的要引入以下依赖, 该版本springboot 版本2.3.1不需要加入
```pom
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```