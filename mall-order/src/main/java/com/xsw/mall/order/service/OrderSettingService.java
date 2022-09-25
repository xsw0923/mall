package com.xsw.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsw.common.utils.PageUtils;
import com.xsw.mall.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 17:07:43
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

