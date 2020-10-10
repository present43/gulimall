package com.liuz.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 10:01:18
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

