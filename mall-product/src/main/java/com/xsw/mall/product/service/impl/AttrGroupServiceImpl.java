package com.xsw.mall.product.service.impl;

import com.xsw.mall.product.entity.AttrEntity;
import com.xsw.mall.product.service.AttrService;
import com.xsw.mall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xsw.common.utils.PageUtils;
import com.xsw.common.utils.Query;

import com.xsw.mall.product.dao.AttrGroupDao;
import com.xsw.mall.product.entity.AttrGroupEntity;
import com.xsw.mall.product.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
//        if (catelogId == 0){
//            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
//                    new QueryWrapper<AttrGroupEntity>());
//
//            return new PageUtils(page);
//        }else {
//            String key = (String) params.get("key");
//            //select * from pms_attr_group where catelog_Id=? and (attr_group_id-key or attr_group_name like %key%)
//            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id",catelogId);
//            if (!StringUtils.isEmpty(key)){
//                wrapper.and((obj)->{
//                    obj.eq("attr_group_id",key).or().like("attr_group_name",key);
//                });
//            }
//            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
//                    wrapper);
//            return new PageUtils(page);
//        }
//    }
        String key = (String) params.get("key");
        //select * from pms_attr_group where catelog_id=? and (attr_group_id=key or attr_group_name like %key%)
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }

        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        } else {
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        }
    }
    /**
     * ????????????id???????????????????????????????????????????????????
     * @param catelogId
     * @return
     */
    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        //com.atguigu.gulimall.product.vo
        //1?????????????????????
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));

        //2?????????????????????
        List<AttrGroupWithAttrsVo> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrsVo attrsVo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(group,attrsVo);
            List<AttrEntity> attrs = attrService.getRelationAttr(attrsVo.getAttrGroupId());
            attrsVo.setAttrs(attrs);
            return attrsVo;
        }).collect(Collectors.toList());

        return collect;
    }
}
