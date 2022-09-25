package com.xu.utils;

import com.xu.vo.ResultVO;

/**
 * HTTP请求返回的最外层对象ResultVO工具类 -- ResultVOUtil
 */
public class ResultVOUtil
{
    /** JSON数据 成功返回  */
    public static ResultVO success(Object object)
    {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    /**
     *
     * @param code
     * @param msg
     * @return 返回自定义消息msg
     */
    public static ResultVO success(Integer code, String msg)
    {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg(msg);
        return resultVO;
    }

    /**
     *
     * @return空消息
     */
    public static ResultVO success()
    {
        return success(null);
    }

}
