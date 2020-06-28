package com.xinyet.read_config;

import com.xinyet.read_config.bean.Config;
import com.xinyet.read_config.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadConfigApplicationTests {

    @Autowired
    private Student student;

    @Autowired
    private Config config;

    @Test
    void contextLoads() {
        System.out.println(config);
        System.out.println(student);
    }
}
