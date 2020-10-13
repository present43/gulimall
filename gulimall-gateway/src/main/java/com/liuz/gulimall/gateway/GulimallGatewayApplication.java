package com.liuz.gulimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关 ： 开启服务的注册与发现
 *
 */

// 开启服务的注册与发现
@EnableDiscoveryClient
// exclude = {DataSourceAutoConfiguration.class} 因为网关用不到数据库 但是common 里面有包含数据库的相关依赖
// 说以剔除 数据库的相关配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GulimallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallGatewayApplication.class, args);
    }

}
