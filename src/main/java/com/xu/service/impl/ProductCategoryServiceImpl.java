package com.xu.service.impl;

import com.xu.dao.IProductCategoryDAO;
import com.xu.entity.ProductCategory;
import com.xu.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductCategoryServiceImpl implements IProductCategoryService
{
    @Autowired
    private IProductCategoryDAO productCategoryDAO;

    /**
     *   categoryId商品类目主键
     *  根据某个商品类目ID查询商品类目
     */
    @Override
    public ProductCategory findById(Integer categoryId) {
        //调用DAO层中,根据某个商品类目ID查询商品类目的方法
        return productCategoryDAO.findById(categoryId).orElse(null);
    }

    /**
     *
     * @return 查询所有的商品类目 (不分页)
     */
    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    /**
     *
     * @param categoryTypeList 商品类目列表
     * @return 根据商品类目ID列表 查询商品类目列表
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return  productCategoryDAO.queryByCategoryTypeIn(categoryTypeList);
    }

    /**
     *
     * @param productCategory 商品类目
     * @return 新增商品类目
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDAO.save(productCategory);
    }
}
