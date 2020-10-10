package com.liuz.gulimall.order.dao;

import com.liuz.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 10:01:18
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
