package com.liuz.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-09-30 14:21:05
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

