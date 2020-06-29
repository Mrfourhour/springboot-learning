package com.xinyet.read_other_config_05;

import com.xinyet.read_other_config_05.bean.Player;
import com.xinyet.read_other_config_05.bean.Player2;
import com.xinyet.read_other_config_05.bean.Student;
import com.xinyet.read_other_config_05.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadOtherConfig05ApplicationTests {

    @Autowired
    private Student student;

    @Autowired
    private User user;

    @Autowired
    private Player player;

    @Autowired
    private Player2 player2;

    @Test
    void contextLoads() {
        System.out.println(student);
        System.out.println(user);
        System.out.println(player);
        System.out.println(player2);
    }

}
