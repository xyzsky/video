package com.xyz.actor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Xyz
 * @Date 2021/6/26
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xyz")
public class VideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }
}
