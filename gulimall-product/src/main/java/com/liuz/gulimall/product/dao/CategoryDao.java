package com.liuz.gulimall.product.dao;

import com.liuz.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-09-30 14:21:06
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
