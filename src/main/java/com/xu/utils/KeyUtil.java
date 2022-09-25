package com.xu.utils;

import java.util.Random;

/**
 * 随机生成主键工具类
 */
public class KeyUtil
{
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String getUniqueKey()
    {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000; // 生成6位的随机数
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
