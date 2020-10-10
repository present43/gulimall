package com.liuz.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使用远程调用的步骤
 * 一： 引入openfeign 远程式声明调用
 * 二： 编写接口，告诉spring-cloud 这个接口需要调用远程服务
 *      1. 加注解 @ feignClient 告诉 spring-cloud 这是一个远程服务客户端，传入需要调用的远程服务名字
 *      2. 加上需要调用的方法的签名
 * 三： 开启远程调用功能
 */

// 开启远程调用功能
@EnableFeignClients(basePackages = "com.liuz.gulimall.member.feign")
// 开启服务注册与发现
@EnableDiscoveryClient
@MapperScan("com.liuz.gulimall.member.dao")
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
