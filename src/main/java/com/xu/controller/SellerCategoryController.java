package com.xu.controller;

import com.xu.entity.ProductCategory;
import com.xu.exception.SellException;
import com.xu.form.CategoryForm;
import com.xu.service.IProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家类目Controller
 */
@Controller
@RequestMapping("/seller/category")

public class SellerCategoryController
{
    @Autowired
    // 商品类目Service
    private IProductCategoryService categoryService;

    /**
     * 查询商品类目列表
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map)
    {
        //  查询所有的商品类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList); // 设置商品类目列表
        return new ModelAndView("category/list", map);
    }

    /**
     * 弹出 商品类目修改页面
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String, Object> map)
    {
        if (categoryId != null)
        {
            ProductCategory productCategory = categoryService.findById(categoryId);
            map.put("category", productCategory);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/更新 商品类目
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map)
    {
        if (bindingResult.hasErrors())
        {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try
        {
            if (form.getCategoryId() != null)
            {
                productCategory = categoryService.findById(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, productCategory);
            categoryService.save(productCategory);
        } catch (SellException e)
        {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }

}
