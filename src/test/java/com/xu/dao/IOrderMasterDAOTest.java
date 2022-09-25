package com.xu.dao;

import com.xu.entity.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 订单主表DAO测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IOrderMasterDAOTest {
    @Autowired
    private IOrderMasterDAO orderMasterDAO;  // 订单主表DAO

    private final String OPENID = "1314520";

    /**  测试订单主表保存方法 */
    @Test
    public void saveTest()
    {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1956782162833543926");
        orderMaster.setBuyerName("小小猪");
        orderMaster.setBuyerPhone("1340196712");
        orderMaster.setBuyerAddress("南京市雨花台区西善桥");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(22.5));

        OrderMaster saveOrderMaster = orderMasterDAO.save(orderMaster);
        Assert.assertNotNull(saveOrderMaster);
    }

    /**  根据微信端的openid查询订单主表信息  */
    @Test
    public void queryByBuyerOpenid() throws Exception
    {
        PageRequest pageResult =  PageRequest.of(0, 2);
        Page<OrderMaster> orderMasterResult =  orderMasterDAO.queryByBuyerOpenid(OPENID, pageResult);
        Assert.assertNotEquals(0, orderMasterResult.getTotalElements());
        System.out.println(orderMasterResult.getTotalElements());

    }

}