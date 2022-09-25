package com.xu.dao;

import com.xu.entity.SellerInfo;
import com.xu.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 卖家信息DAO 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISellerInfoDAOTest
{
    // 用户信息DAO
    @Autowired
    private ISellerInfoDAO sellerInfoDAO;
    /** 添加用户信息  */
    @Test
    public void save()
    {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("xuopenid");

        SellerInfo result = sellerInfoDAO.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid() throws Exception
    {
        SellerInfo sellerInfo = sellerInfoDAO.findByOpenid("xuopenid");
        Assert.assertEquals("xuopenid", sellerInfo.getOpenid());
    }

}

