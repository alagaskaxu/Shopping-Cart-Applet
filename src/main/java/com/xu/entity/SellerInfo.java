package com.xu.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 卖家信息表 对应的 JavaBean
 */
@Entity
@Data
@DynamicUpdate
public class SellerInfo
{
    /**
     * 卖家信息表 主键
     */
    @Id
    private String sellerId;

    /**
     * 用户名(这里没有用到 -- 为了以后的扩展)
     */
    private String username;

    /**
     * 密码(这里没有用到 -- 为了以后的扩展)
     */
    private String password;

    /**
     * 扫码登录 就用openid
     */
    private String openid;
}


