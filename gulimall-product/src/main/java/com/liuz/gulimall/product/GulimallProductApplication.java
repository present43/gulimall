package com.liuz.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 整合Mybatis-plus 的步骤
 * 一： 导入依赖
 * 二： 导入数据库驱动
 *
 * 上两步可以配置在公共文件夹
 * 下两步因为不同的服务连接的库不一样，所以配置在服务内
 *
 * 三：配置数据源相关信息
 * 四：配置映射文件扫描
 *
 * 五：告诉持久层框架映射文件的位置
 */

@MapperScan("com.liuz.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
