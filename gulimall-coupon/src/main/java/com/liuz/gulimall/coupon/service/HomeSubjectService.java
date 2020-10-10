package com.liuz.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.coupon.entity.HomeSubjectEntity;

import java.util.Map;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-09-30 17:12:54
 */
public interface HomeSubjectService extends IService<HomeSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

