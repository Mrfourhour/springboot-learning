package com.xinyet.read_other_config_05;

import com.xinyet.read_other_config_05.config.PropertySourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({@PropertySource("classpath:student.properties"),
        @PropertySource("classpath:user.properties"),
        @PropertySource(value = "classpath:player.yml", factory = PropertySourceFactory.class),
        @PropertySource(value = "classpath:player2.yml", factory = PropertySourceFactory.class)})
//@PropertySource(value = "classpath:student.properties")
//@PropertySource(value = "classpath:user.properties")
//@PropertySource(value = "classpath:player.yml", factory = PropertySourceFactory.class)
//@PropertySource(value = "classpath:other.yml", factory = PropertySourceFactory.class)
@SpringBootApplication
public class ReadOtherConfig05Application {
    public static void main(String[] args) {
        SpringApplication.run(ReadOtherConfig05Application.class, args);
    }
}
