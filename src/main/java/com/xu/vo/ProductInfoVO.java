package com.xu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 */
@Data
public class ProductInfoVO
{
    @JsonProperty("id")// jaon映射productId->id
    private String productId;  // 商品编号

    @JsonProperty("name")
    private String productName; // 商品名称

    @JsonProperty("price")
    private BigDecimal productPrice;  // 商品单价

    @JsonProperty("description")
    private String productDescription;  // 商品描述

    @JsonProperty("icon")
    private String productIcon;

}
