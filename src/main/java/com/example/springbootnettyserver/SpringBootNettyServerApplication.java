package com.example.springbootnettyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootNettyServerApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(SpringBootNettyServerApplication.class, args);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
