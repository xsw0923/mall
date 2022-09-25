package com.xsw.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsw.common.utils.PageUtils;
import com.xsw.mall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 16:59:20
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

