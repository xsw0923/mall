package com.xsw.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsw.common.utils.PageUtils;
import com.xsw.mall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 16:59:20
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

