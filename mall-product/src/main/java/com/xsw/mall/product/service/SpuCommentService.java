package com.xsw.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xsw.common.utils.PageUtils;
import com.xsw.mall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 15:31:22
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

