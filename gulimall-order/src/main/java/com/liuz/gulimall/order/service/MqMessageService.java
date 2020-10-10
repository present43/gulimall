package com.liuz.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.order.entity.MqMessageEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 10:01:19
 */
public interface MqMessageService extends IService<MqMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

