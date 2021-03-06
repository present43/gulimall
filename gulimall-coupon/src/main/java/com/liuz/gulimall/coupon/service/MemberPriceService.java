package com.liuz.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-09-30 17:12:54
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

