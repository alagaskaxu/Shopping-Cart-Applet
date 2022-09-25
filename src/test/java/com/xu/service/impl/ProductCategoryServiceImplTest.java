package com.xu.service.impl;

import com.xu.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    /**  根据某个商品类目ID查询商品类目 */
    @Test
    public void findById() throws Exception
    {
        ProductCategory productCategory = productCategoryService.findById(111);
        Assert.assertEquals(new Integer(111), productCategory.getCategoryId());
    }
    /*
    查询所有的商品类目 (不分页)
     */
    @Test
    public void findAll() throws Exception
    {
        List<ProductCategory> productCategory = productCategoryService.findAll();
        System.out.println(productCategory);
    }

    /**
     *
     *根据商品类目ID列表 查询商品类目列表
     */
    @Test
    public void findByCategoryTypeIn() throws Exception
    {
        //商品类别ID
        List<ProductCategory>   productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(0,1,2));
        Assert.assertNotEquals(0, productCategoryList.size());

    }

    /**
     *
     * 新增商品类目
     */
    @Test
    public void save() throws Exception
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("折扣商品");
        productCategory.setCategoryType(4);

        ProductCategory saveProductCategory = productCategoryService.save(productCategory);
        Assert.assertNotNull(saveProductCategory);

    }

}