package com.xu.service;

import com.xu.dto.OrderDTO;

/**
 *买家service
 */
public interface IBuyerService
{
    /** 查询一个订单 */
    OrderDTO findOrderOne(String openid, String orderId);

    /**  取消订单 */
    OrderDTO cancelOrder(String openid, String orderId);

}
