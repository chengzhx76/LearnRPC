package com.cheng.rpc.invoke;

/**
 * Created by version_z on 2015/8/23.
 */
public class ProviderConfig
{
    private String target;
    private Integer port;

    public ProviderConfig() {
    }

    public ProviderConfig(String target, Integer port) {
        this.target = target;
        this.port = port;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
