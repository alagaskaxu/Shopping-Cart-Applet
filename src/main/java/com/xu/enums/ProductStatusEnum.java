package com.xu.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum implements CodeEnum
{
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum()
    {

    }
    ProductStatusEnum(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }

}
