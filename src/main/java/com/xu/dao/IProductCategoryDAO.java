package com.xu.dao;

import com.xu.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目DAO持久层
 */
public interface IProductCategoryDAO extends JpaRepository<ProductCategory,Integer>
{
    /**
     *
     * @param categoryTypeList 商品类目列表
     * @return 根据商品类目ID列表 查询商品类目列表
     */
    List<ProductCategory> queryByCategoryTypeIn(List<Integer> categoryTypeList);
}
