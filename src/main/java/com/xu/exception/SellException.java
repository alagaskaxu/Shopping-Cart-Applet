package com.xu.exception;

import com.xu.enums.ResultEnum;
import lombok.Getter;

/**
 * 异常类
 */
@Getter
public class SellException extends RuntimeException
{
    private Integer code;

    public SellException(ResultEnum resultEnum)
    {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message)
    {
        super(message);
        this.code = code;
    }

}
