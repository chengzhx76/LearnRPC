package com.cheng.rpc.proxy;

import com.cheng.rpc.invoke.ConsumerConfig;
import com.cheng.rpc.invoke.HttpInvoker;
import com.cheng.rpc.invoke.Invoker;
import com.cheng.rpc.serialize.Formater;
import com.cheng.rpc.serialize.Parser;
import com.cheng.rpc.serialize.json.JsonFormater;
import com.cheng.rpc.serialize.json.JsonParser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by version_z on 2015/8/22.
 */
public class ConsumerProxyFactory implements InvocationHandler
{
    private ConsumerConfig consumerConfig;

    private Parser parser = JsonParser.parser;

    private Formater formater = JsonFormater.formater;

    private Invoker invoker = HttpInvoker.invoker;

    private String clazz;

    public Object create() throws Exception {
        Class interfaceClass = Class.forName(clazz);
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[]{interfaceClass},this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Class interfaceClass = proxy.getClass().getInterfaces()[0];
        String req = formater.reqFormat(interfaceClass,method.getName(),args[0]);
        String resb = invoker.request(req,consumerConfig);
        return parser.rsbParse(resb);
    }

    public ConsumerConfig getConsumerConfig() {
        return consumerConfig;
    }

    public void setConsumerConfig(ConsumerConfig consumerConfig) {
        this.consumerConfig = consumerConfig;
    }
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }

    public Formater getFormater() {
        return formater;
    }

    public void setFormater(Formater formater) {
        this.formater = formater;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
