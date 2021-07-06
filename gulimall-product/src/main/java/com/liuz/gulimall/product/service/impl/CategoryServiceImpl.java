package com.liuz.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuz.common.utils.PageUtils;
import com.liuz.common.utils.Query;

import com.liuz.gulimall.product.dao.CategoryDao;
import com.liuz.gulimall.product.entity.CategoryEntity;
import com.liuz.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    // 注入持久层服务
    @Autowired
    CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );
        return new PageUtils(page);
    }

    /**
     *  树形菜单的 业务逻辑
     * @return
     */
    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有分类
        List<CategoryEntity> entityList = categoryDao.selectList(null);

        /**
         *组装成父子的树型结构
         *      1. 通过stream 流过滤出 getParentCid() == 0 的对象 即一级分类
         *      2. 将一级分类收集成一个集合 再对其进行遍历 调用setChildren 设置对象
         *      3. 之后对 里面再调用递归去遍历
         */
        List<CategoryEntity> level1Menus = entityList.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0).map(
                menu -> {
                    // 将当前菜单的子分类设置进去
                    menu.setChildren(getChildren(menu , entityList ));
                    // 返回当前菜单
                    return menu;
                }
        // 对菜单进行排序
        ).sorted( (menu1,menu2) -> {
            return (menu1.getSort() ==null ? 0:menu1.getSort())- (menu2.getSort()==null?0:menu2.getSort());
        } ).collect(Collectors.toList());

        return level1Menus;
    }


    @Override
    public void removeByCatIds(List<Long> asList) {
        //TODO 删除之前需要检查 此菜单是否存在应用

        // 直接删除数据库内的数据 即物理删除  -- 一般不这样
        categoryDao.deleteBatchIds(asList);

        // 逻辑删除

    }


    // 递归查询出 所有的菜单的子菜单
    private List<CategoryEntity> getChildren(CategoryEntity root ,List<CategoryEntity> all) {

        List<CategoryEntity> childrens = all.stream().filter( i ->{
            return i.getParentCid() == root.getCatId();
        }).map(i -> {
            i.setChildren(getChildren(i,all));
            return i;
        }).sorted( (menu1,menu2) -> {
            return (menu1.getSort() ==null ? 0:menu1.getSort())- (menu2.getSort()==null?0:menu2.getSort());
        } ).collect(Collectors.toList());

        return childrens;
    }


}