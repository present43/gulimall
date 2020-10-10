package com.liuz.gulimall.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.store.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 10:13:30
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

