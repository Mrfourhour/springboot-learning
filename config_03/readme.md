# 配置文件-application.yml

## 1.yml文件的基本语法
  - 大小写敏感
  - 使用缩进表示层级关系
  - 缩进不允许使用tab，只允许空格
  - 缩进的空格数不重要，只要相同层级的元素左对齐即可
  - '#'表示注释
## 2. yml文件的数据类型
  1.对象 键值的集合
  ```yaml
  student: {name: 张三, age: 24, gender: 男}  
  student2:
    name: 潘金莲
    age: 22
    gender: 女
  ```
  2.数组 一组按次序排列的值
  ```yaml
   animal:
     - dog
     - bird
     - cat
   pets: [dog,bird,cat]
```
  3.纯量 单个的、不可再分的值
  ```yaml
  isEnable: true
  redisKey: this_is_a_readis_key
```

注意点: 字符串默认不用加上单引号或者双引号
 - 双引号: 不会转义字符串里面的特殊字符;特殊字符会作为本身想表示的意思
  ```yaml
 name: "wudalang \n panjinlian"
```
   输出: wudalang 换行 panjinlian
 - 单引号: 会转义特殊字符，特殊字符最终只是一个普通的字符串数据
 ```yaml
 name: 'wudalang \n panjinlian'
```
   输出: wudalang \n panjinlian