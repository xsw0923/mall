package com.xsw.mall.member.fegin;

import com.xsw.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "mall-coupon")
public interface CouponFeginService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
