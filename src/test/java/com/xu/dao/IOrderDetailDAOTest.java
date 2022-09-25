package com.xu.dao;

import com.xu.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 订单明细表DAO 单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class IOrderDetailDAOTest
{
    @Autowired
    private IOrderDetailDAO orderDetailDAO;

    /**  新增订单明细 */
    @Test
    public void saveTest()
    {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("3");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(22.5));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDetailDAO.save(orderDetail);
        Assert.assertNotNull(result);
    }
    /** 根据订单编号 查询相关订单信息 */
    @Test
    public void findByOrderId() throws Exception
    {
        List<OrderDetail> orderDetailList = orderDetailDAO.findByOrderId("11111112");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}