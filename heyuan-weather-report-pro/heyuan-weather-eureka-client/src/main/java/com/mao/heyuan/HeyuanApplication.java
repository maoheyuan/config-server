package com.mao.heyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class HeyuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeyuanApplication.class, args);
    }

}
