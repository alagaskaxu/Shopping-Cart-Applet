package com.xu.service;

import com.xu.dto.CartDTO;
import com.xu.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductInfoService
{
    /** 根据商品ID查询商品信息 */
    ProductInfo findById(String productId);

    /** 查询所有上架商品信息列表  */
    List<ProductInfo> findUpAll();

    /** 分页查询所有商品信息列表  */
    Page<ProductInfo> findAll(Pageable pageable);

    /** 新增商品  */
    ProductInfo save(ProductInfo productInfo);

    /** 加库存 */
    void increaseStock(List<CartDTO> cartDTOList);

    /** 减库存 */
    void decreaseStock(List<CartDTO> cartDTOList);

    /** 商品上架 */
    ProductInfo onSale(String productId);

    /** 商品下架 */
    ProductInfo offSale(String productId);

}
