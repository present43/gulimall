package com.liuz.gulimall.product.controller;

import java.lang.reflect.Array;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuz.gulimall.product.entity.CategoryEntity;
import com.liuz.gulimall.product.service.CategoryService;
import com.liuz.common.utils.PageUtils;
import com.liuz.common.utils.R;



/**
 * 商品三级分类
 *
 * @author liuz
 * @email 2351810431@qq.com
 * @date 2020-09-30 14:21:06
 */
@Slf4j
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 树状目录： 查询所有分类和子分类以树型菜单封装
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> entities = categoryService.listWithTree();
        return  R.ok().put("data", entities);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
        // Arrays.asList(catIds) 将数组转换成一个集合
        // categoryService.removeByIds(Arrays.asList(catIds));
        categoryService.removeByCatIds(Arrays.asList(catIds));

        return R.ok();
    }

    /**
     * 批量拖拽 -- 排序 保存
     * [] 看最外层的括号 是数组就用数组接
     * 是 {} 为对象 就用list 接
     */
    @RequestMapping("/update/sort")
    public R sort(@RequestBody CategoryEntity [] categoryEntities) {
        // 参数校验
        List<CategoryEntity> categoryEntityList = Arrays.asList(categoryEntities);
        log.info("sort request {} ", JSONObject.toJSONString(categoryEntities));
        categoryEntityList.removeIf(Objects::isNull);
        if (categoryEntityList.size() == 0) {
            return R.error("参数不能为空");
        }
        categoryService.updateBatchById(categoryEntityList);
        return R.ok("排序成功");
    }


}
