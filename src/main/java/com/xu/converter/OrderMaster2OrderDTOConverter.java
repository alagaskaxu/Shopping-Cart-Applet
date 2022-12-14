package com.xu.converter;

import com.xu.dto.OrderDTO;
import com.xu.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 将OederMaster 转换成 OrderDTO
 */
public class OrderMaster2OrderDTOConverter
{
    /** 将 OrderMaster 转换成 OrderDTO */
    public static OrderDTO convert(OrderMaster orderMaster)
    {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    /** 将  List<OrderMaster> 转换成  List<OrderDTO>  */
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList)
    {
        return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }

}
