package com.liuz.gulimall.store;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.liuz.gulimall.store.dao")
@SpringBootApplication
public class LiuzStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiuzStoreApplication.class, args);
    }

}
