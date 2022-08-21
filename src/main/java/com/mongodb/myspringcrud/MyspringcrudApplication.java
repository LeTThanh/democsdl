package com.mongodb.myspringcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MyspringcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringcrudApplication.class, args);
    }
}
