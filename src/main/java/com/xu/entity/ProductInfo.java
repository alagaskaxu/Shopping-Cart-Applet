package com.xu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xu.enums.CodeEnum;
import com.xu.enums.ProductStatusEnum;
import com.xu.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
     * 商品表 对应的  JavaBean
     * Created by liyan on 2021/7/17.
     */
    @Entity
    @Data
    @DynamicUpdate
    public class ProductInfo implements Serializable
    {
        private static final long serialVersionUID = 1L;

        @Id
        private String productId;  // 注意商品ID没有主键自增

        /**
         * 名字.
         */
        private String productName;

        /**
         * 单价.
         */
        private BigDecimal productPrice;

        /**
         * 库存.
         */
        private Integer productStock;

        /**
         * 描述.
         */
        private String productDescription;

        /**
         * 小图.
         */
        private String productIcon;

        /**
         * 状态, 0-正常  1-下架.
         */
        private Integer productStatus = ProductStatusEnum.UP.getCode();

        /**
         * 类目编号.
         */
        private Integer categoryType;

        /** 创建时间 */
        @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
        private Date createTime;

        /** 修改时间 */
        @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
        private Date updateTime;

        /** 获取产品的枚举类: 商品的各个状态都在里面 */
        @JsonIgnore
        public ProductStatusEnum getProductStatusEnum()
        {
            return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
        }

    }
