package com.cheng.rpc.invoke;

import com.cheng.rpc.exception.RpcException;

import java.io.OutputStream;

/**
 * Created by version_z on 2015/8/22.
 */
public interface Invoker
{
    /**
     * 调用请求
     * @param request 请求报文
     * @param consumerConfig 消费者配置
     * @return
     * @throws RpcException
     */
    String request(String request, ConsumerConfig consumerConfig) throws RpcException;

    /**
     * 请求应答
     * @param response 响应报文
     * @param outputStream 输出流
     * @throws RpcException
     */
    void response(String response, OutputStream outputStream) throws RpcException;
}
