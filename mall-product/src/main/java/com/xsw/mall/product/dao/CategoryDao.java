package com.xsw.mall.product.dao;

import com.xsw.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xsw
 * @email xsw20000923@gmail.com
 * @date 2022-09-08 15:31:22
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
