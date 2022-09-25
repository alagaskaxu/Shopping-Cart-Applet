package com.xu.dao;

import com.xu.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表DAO
 */
public interface IOrderMasterDAO extends JpaRepository<OrderMaster, String>
{
    /**  根据微信端的openid查询订单主表信息  */
    Page<OrderMaster> queryByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
