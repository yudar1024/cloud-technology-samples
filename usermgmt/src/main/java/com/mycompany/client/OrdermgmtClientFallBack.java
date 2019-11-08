package com.mycompany.client;

public class OrdermgmtClientFallBack implements OrdermgmtClient {

    @Override
    public String serviceName() {
        return "here is the default fallback for method serviceName";
    }
}
