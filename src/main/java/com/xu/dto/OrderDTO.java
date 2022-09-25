package com.xu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xu.entity.OrderDetail;
import com.xu.enums.OrderStatusEnum;
import com.xu.enums.PayStatusEnum;
import com.xu.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object 数据传输对象
 */
@Data
// 当JSON返回数据中的属性名对应的属性值为null是则最终返回的JSON数据中就不返回
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class OrderDTO implements Serializable
{
    private static final long serialVersionUID = 1L;
    /** 订单id */
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信Openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单  */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付  */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 订单明细列表 */
    //List<OrderDetail> orderDetailList = new ArrayList<>();
    List<OrderDetail> orderDetailList;

    /** 获取 订单状态 枚举常量类 */
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum()
    {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    /** 获取 支付状态 枚举常量类 */
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum()
    {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
