package com.xsw.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsw.common.utils.PageUtils;
import com.xsw.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 15:31:22
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

