package com.xu.dao;

import com.xu.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductInfoDAO extends JpaRepository<ProductInfo, String>
{
    /** 通过商品的状态来查上架的商品 */
    List<ProductInfo> queryByProductStatus(Integer productStatus);
}
