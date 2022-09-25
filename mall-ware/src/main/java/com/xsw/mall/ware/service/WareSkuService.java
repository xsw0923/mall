package com.xsw.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsw.common.utils.PageUtils;
import com.xsw.mall.ware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 17:10:56
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);
}

