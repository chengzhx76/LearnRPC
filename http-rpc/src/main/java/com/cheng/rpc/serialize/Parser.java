package com.cheng.rpc.serialize;

import com.cheng.rpc.exception.RpcException;

/**
 * Created on 2015/8/17.
 */
public interface Parser
{
    /**
     *
     * @param param 请求参数
     * @return
     */
    Request reqParse(String param) throws RpcException;

    /**
     *
     * @param result
     * @return
     */
    public <T> T rsbParse(String result);
}
