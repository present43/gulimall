package com.liuz.gulimall.member.dao;

import com.liuz.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 09:43:16
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
