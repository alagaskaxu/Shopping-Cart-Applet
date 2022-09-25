package com.xu.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductCategory
{
    /* 序列化ID */
    private static final long serialVersionUID = 1L;

    /** 类目id */
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主键自增
    private Integer categoryId;

    /** 类目名 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    /**  创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;
}
