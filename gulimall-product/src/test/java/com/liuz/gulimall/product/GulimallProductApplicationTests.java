package com.liuz.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuz.gulimall.product.entity.BrandEntity;
import com.liuz.gulimall.product.service.BrandService;
import com.liuz.gulimall.product.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandServiceImpl brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity =  new BrandEntity();
        List<BrandEntity> brand = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        brand.forEach(i -> {
            System.out.println(i);
        });
    }

}
