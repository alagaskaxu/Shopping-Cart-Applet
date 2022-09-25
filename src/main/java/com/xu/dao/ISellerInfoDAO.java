package com.xu.dao;

import com.xu.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卖家信息DAO
 */
public interface ISellerInfoDAO extends JpaRepository<SellerInfo, String>
{
    /** 根据openid查询用户信息  */
    SellerInfo findByOpenid(String openid);
}
