package com.xu.service.impl;

import com.xu.entity.ProductInfo;
import com.xu.enums.ProductStatusEnum;
import com.xu.service.IProductInfoService;
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
@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductInfoServiceImplTest
{
    @Autowired
    private IProductInfoService productService;

    /** 根据商品ID查询商品信息 */
    @Test
    public void findById() throws Exception
    {
        ProductInfo productInfo = productService.findById("1");
        Assert.assertEquals("1", productInfo.getProductId());
    }

    /** 查询所有上架商品信息列表  */
    @Test
    public void findUpAll() throws Exception
    {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    /** 分页查询所有商品信息列表  */
    @Test
    public void findAll() throws Exception
    {
        // PageRequest implements Pageable, Serializable
        PageRequest request = PageRequest.of(1, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    /** 新增商品  */
    @Test
    public void save() throws Exception
    {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("5");
        productInfo.setProductName("葡萄汁露");
        productInfo.setProductPrice(new BigDecimal(18.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝啊");
        productInfo.setProductIcon("http://aaaaaa.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);

    }
    /** 商品上架 */
    @Test
    public void onSale()
    {
        ProductInfo result = productService.onSale("1");
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    /** 商品下架 */
    @Test
    public void offSale()
    {
        ProductInfo result = productService.offSale("1");
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }


}