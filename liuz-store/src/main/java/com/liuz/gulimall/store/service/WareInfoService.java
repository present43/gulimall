package com.liuz.gulimall.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuz.common.utils.PageUtils;
import com.liuz.gulimall.store.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 10:13:30
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

