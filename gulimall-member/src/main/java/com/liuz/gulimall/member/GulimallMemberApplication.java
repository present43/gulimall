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
 *
 * 配置中心的使用步骤
 * 一： 引入依赖 spring-cloud-starter-alibaba-nacos-config
 * 二： 配置远程配置中心的地址值 和服务的名称
 * 三： 给配置中心添加一个默认的 数据集合
 * 四： 动态获取配置
 *
 * 配置中心细节：
 * 命名空间 ： 就是不同的环境 来做配置隔离
 *          注意[切换命名空间在 bootstrap.properties 切换唯一ID ]
 *              [方法二：除了基于开发环境去写配置， 也可以去基于 微服务去写配置 对应着命名空间，只加载自己命名空间下的配置]
 * 配置集 ： 一组相关的或者不相关的配置的集合
 * 配置集ID ：类似于配置文件名，在nacos 中为 DataID
 * 配置分组： 默认所有的配置集都属于 DEFAULT_GROUP
 *
 * 最终方案： 每个微服务创造自己的命名空间 使用配置分组来区分使用环境 【秒啊】
 *            test  dev  prop
 配置文件加载的优先级（由高到低）
 bootstrap.properties ->bootstrap.yml -> application.properties -> application.yml

 同时加载多个配置集 使用步骤
 1.任何微服务配置都可以迁移到nacos配置中心
 2.我们只需要在 bootstrap.properties 中说明加载那些配置文件即可
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
