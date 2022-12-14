package com.xu.service.impl;

import com.xu.dto.OrderDTO;
import com.xu.entity.OrderDetail;
import com.xu.enums.OrderStatusEnum;
import com.xu.enums.PayStatusEnum;
import com.xu.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 订单service测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class OrderServiceImplTest
{
    @Autowired
    private IOrderService orderService; // 订单Service

    private final String BUYER_OPENID = "1101110";
    // 订单ID(该订单ID要在DB中存在)
    private final String ORDER_ID = "1629275807747331537";

    /**
     * 创建订单测试
     *
     */
    @Test
    public void create() throws Exception
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("清风");
        orderDTO.setBuyerAddress("南京");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1");          // 设置商品ID(要在库中真实存在)
        o1.setProductQuantity(1);      // 设置购买商品数量

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("2");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);   // 将订单明细放入到 订单明细列表中
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList); // 设置商品明细列表

        OrderDTO result = orderService.create(orderDTO);  // 创建订单

        log.info("[创建订单] result={}", result);
        Assert.assertNotNull(result);

    }

    /**
     *根据订单Id查询订单列表
     */
    @Test
    public void findById() throws Exception
    {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        log.info("[查询单个订单] orderDTO={}", orderDTO);
        Assert.assertEquals(ORDER_ID, orderDTO.getOrderId());

    }
    /**  查询订单列表  */
    @Test
    public void findList() throws Exception
    {
        // 查询第0页的数据 每页显示2条数据
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());

    }

    /**
     * 取消订单
     *
     */
    @Test
    public void cancel() throws Exception
    {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);   // 取消订单
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());

    }
    /**  完结订单  */
    @Test
    public void finish() throws Exception
    {
        // 根据订单编号查询订单信息
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        // 完结订单
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }
    //支付订单
    @Test
    public void paid() throws Exception
    {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    /**   带分页 查询所有的订单列表   */
    @Test
    public void list()
    {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPageList = orderService.findList(request);
        //Assert.assertNotEquals(0, orderDTOPageList.getTotalElements());
        Assert.assertTrue("带分页查询所有的订单列表", orderDTOPageList.getTotalElements() > 0);
    }

}