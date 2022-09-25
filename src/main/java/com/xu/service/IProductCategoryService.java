package com.xu.service;

import com.xu.entity.ProductCategory;

import java.util.List;

/**
 * 商品类目Service
 * Created by liyan on 2021/7/17.
 */

public interface IProductCategoryService
{
    /**  根据某个商品类目ID查询商品类目 */
    ProductCategory findById(Integer categoryId);

    /** 查询所有的商品类目 (不分页)*/
    List<ProductCategory> findAll();

    /**  根据商品类目ID列表 查询商品类目列表 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**  新增商品类目 */
    ProductCategory save(ProductCategory  productCategory);

}
