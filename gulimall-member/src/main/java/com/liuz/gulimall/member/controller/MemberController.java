package com.liuz.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.liuz.gulimall.member.feign.CouponFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuz.gulimall.member.entity.MemberEntity;
import com.liuz.gulimall.member.service.MemberService;
import com.liuz.common.utils.PageUtils;
import com.liuz.common.utils.R;



/**
 * 会员
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-10-10 09:43:16
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // 注入远程服务接口
    @Autowired
    CouponFeignService couponFeignService;


    // 测试远程调用的方法
    @RequestMapping("/coupon")
    public R  test (){
        MemberEntity memberEntity = new MemberEntity();
        // M模拟一个会员 正常情况下是需要到数据库里去查询的
        memberEntity.setNickname("铁柱");
        // 远程获取此会员的优惠卷
        R membercoupon = couponFeignService.membercoupon();

        return  R.ok().put("member", memberEntity ).put("coupon",membercoupon.get("coupon"));

    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
