package com.xu.utils;

import com.xu.enums.CodeEnum;

/**
 * 枚举常量工具类
 */

public class EnumUtil
{
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass)
    {
        // 遍历枚举
        for (T eachEnum : enumClass.getEnumConstants())
        {
            // 判断Code是否相等
            if (code.equals(eachEnum.getCode()))
            {
                return eachEnum;
            }
        }
        return null;
    }

}
