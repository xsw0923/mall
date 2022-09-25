package com.xsw.mall.member.dao;

import com.xsw.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 16:59:20
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
