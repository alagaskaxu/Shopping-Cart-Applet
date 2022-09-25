package com.xu.controller;

import com.xu.entity.ProductCategory;
import com.xu.entity.ProductInfo;
import com.xu.service.IProductCategoryService;
import com.xu.service.IProductInfoService;
import com.xu.utils.ResultVOUtil;
import com.xu.vo.ProductInfoVO;
import com.xu.vo.ProductVO;
import com.xu.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://localhost:8080/sell/buyer/product/list
 */
@RestController // 返回JSON数据
@RequestMapping("/buyer/product")

public class BuyerProductInfoController
{
    /**
     *
     * @return 商品列表
     */
    @Autowired
    private IProductInfoService productInfoService;  // 商品Service

    @Autowired
    private IProductCategoryService  productCategoryService; // 商品类目Service
    @GetMapping("/list")
    public ResultVO List()
    {
        // (1)查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // (2)查询商品类目列表 (1)和(2) 一次性查询
            /*
        List<Integer>  categoryTypeList = new ArrayList<Integer>();
        for (ProductInfo productInfo : productInfoList)
        {
            // 从 查询到所有的上架商品中取出所有的 商品类目编号 productInfo.getCategoryType() 设置到 查询商品类目列表中
            categoryTypeList.add(productInfo.getCategoryType());
        }
        */
        // 查询商品类目列表
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        // 查询商品类目列表
        // 查询不要放在for循环里面去  !!!!!!!!!!!!!!!!!!!!!!!!!!!
        List<ProductCategory>  productCategoryList  = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        // (3)拼接数据
        // 创建一个空的商品列表
        List<ProductVO> productVOList = new ArrayList<ProductVO>();

        // 遍历商品类目列表
        // 查询不要放在for循环里面去  !!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (ProductCategory productCategory : productCategoryList)
        {
            ProductVO  productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            // 创建一个空的商品详情列表
            List<ProductInfoVO>  productInfoVOList = new ArrayList<ProductInfoVO>();
            // 遍历商品列表
            for (ProductInfo productInfo2 : productInfoList)
            {
                // 判断商品类目是否相等
                if (productInfo2.getCategoryType().equals(productCategory.getCategoryType()))
                {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                      /*
                      productInfoVO.setProductId(productInfo2.getProductId());
                      productInfoVO.setProductName(productInfo2.getProductName());
                      productInfoVO.setProductPrice(productInfo2.getProductPrice());
                      productInfoVO.setProductDescription(productInfo2.getProductDescription());
                      productInfoVO.setProductIcon(productInfo2.getProductIcon());
                      */

                    // 以上几个set合并为 以下这个方法 BeanUtils.copyProperties(src, dest);
                    BeanUtils.copyProperties(productInfo2, productInfoVO);
                    productInfoVOList.add(productInfoVO);  // 将商品详情对象 放置到 商品详情列表中
                }
            } // end of 内层for循环
            productVO.setProductInfoVOList(productInfoVOList); // 设置商品详情列表
            productVOList.add(productVO);

        } // end of 外层for循环

        /*ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        // resultVO.setData(productVO);  // 将ProductVO设置到data中 ---  ProductVO是商品对象(包含商品类目)
        resultVO.setData(productVOList);
        return resultVO;*/
        //调用utils工具类
        return ResultVOUtil.success(productVOList);
    }

}
