package com.xinyet.helloworld_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller /*声明这是个controller并将其托管给spring */
public class TestController {
    @ResponseBody/*@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，通常用来返回JSON数据或者是XML数据。*/
    @RequestMapping("/hello")/*请求路径*/
    public String hello(){
        return "hello springboot";
    }
}
