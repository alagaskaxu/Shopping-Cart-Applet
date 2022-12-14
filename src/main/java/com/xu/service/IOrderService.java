package com.xu.service;

import com.xu.dto.OrderDTO;
import com.xu.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单Service层
 */
public interface IOrderService
{
    /**  创建订单  */
    OrderDTO create(OrderDTO orderDTO);

    /**  查询单个订单  */
    OrderDTO  findById(String orderId);

    /**  查询某个用户的订单列表  */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**  取消订单  */
    OrderDTO cancel(OrderDTO orderDTO);

    /**  完结订单  */
    OrderDTO finish(OrderDTO orderDTO);

    /**  支付订单  */
    OrderDTO paid(OrderDTO orderDTO);

    /**  带分页查询所有的订单列表  */
    Page<OrderDTO> findList(Pageable pageable);

}
