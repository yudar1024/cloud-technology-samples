package com.mycompany.client;

public class OrdermgmtClientFallBack implements OrdermgmtClient {

    @Override
    public String serviceName() {
        return "here is the default fallback for method serviceName";
    }

    @Override
    public String getServiceInfo(String serviceName, Integer age) {
        return null;
    }
}
