package com.xu.service.impl;

import com.xu.dao.ISellerInfoDAO;
import com.xu.entity.SellerInfo;
import com.xu.service.ISellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 卖家端用户信息Service实现类
 */
@Service
@Transactional

public class SellerInfoServiceImpl implements ISellerInfoService
{
    /** 卖家信息DAO */
    @Autowired
    private ISellerInfoDAO sellerInfoDAO;
    /**
     * 通过openid查询卖家端信息
     */
    public SellerInfo findSellerInfoByOpenid(String openid)
    {
        return sellerInfoDAO.findByOpenid(openid);
    }

}
