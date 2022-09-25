package com.xu.dao;

import com.xu.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IProductCategoryDAOTest
{
    @Autowired
    IProductCategoryDAO IProductCategoryDAO;

    /**
     * 根据主键查询
     */
    @Test

    public void FindByIdTest()
    {
        ProductCategory productCategory = IProductCategoryDAO.findById(111).orElse(null);
        //Assert.assertNotEquals(null,productCategory);
        Assert.assertNotNull(productCategory);//不为空通过
    }

    /**
     *  新增商品类目
     *  Table '项目名称..hibernate_sequence' doesn't exist的解决方法:
     *  https://blog.csdn.net/Interesting_Talent/article/details/81454104
     */
    @Test
    @Transactional//回滚,测试完数据回滚
    public void saveTest()
    {
        ProductCategory productCategory = new  ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(4);
        //新增无主键
        //休息有主键
        IProductCategoryDAO.save(productCategory);
    }

    /*  修改商品类目
   *  更新/修改 还是调用 save方法  只不过要更新主键categoryId
   */
    @Test
    public void saveUpdateProductCategoryTest()
    {
        ProductCategory productCategory = new  ProductCategory();
        productCategory.setCategoryId(112);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(5);
        IProductCategoryDAO.save(productCategory);
    }

    @Test
    public void saveTest3()
    {
        // ProductCategory productCategory = new  ProductCategory();
        ProductCategory productCategory = IProductCategoryDAO.findById(112).orElse(null);
        productCategory.setCategoryType(6);
        IProductCategoryDAO.save(productCategory);
    }


}