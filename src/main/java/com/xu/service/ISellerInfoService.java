package com.xu.service;

import com.xu.entity.SellerInfo;

/**
 * 卖家端用户信息Service接口
 */

public interface ISellerInfoService
{
    /**
     * 通过openid查询卖家端信息
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
