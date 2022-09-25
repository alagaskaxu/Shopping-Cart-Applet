package com.xu.dao;

import com.xu.entity.ProductInfo;
import com.xu.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 商品DAO 测试类
 * Created by liyan on 2021/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class IProductInfoDAOTest {
    @Autowired
    private IProductInfoDAO productInfoDAO;
    /**  测试新增商品 */
    @Test
    public void saveTest() throws Exception
    {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("双皮奶");
        productInfo.setProductPrice(new BigDecimal(5.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的双皮奶");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(2);

        ProductInfo productInfoSave = productInfoDAO.save(productInfo);
        Assert.assertNotNull(productInfoSave);
    }

    /** 通过商品的状态来查上架的商品 */

    @Test
    public void queryByProductStatus() throws Exception
    {
        List<ProductInfo> productInfoList = productInfoDAO.queryByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());

    }

}