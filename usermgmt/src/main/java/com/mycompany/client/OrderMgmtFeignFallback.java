package com.mycompany.client;

import org.springframework.stereotype.Component;

@Component
public class OrderMgmtFeignFallback implements OrderMgmtFeignClient {

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "fall back get Info";
	}
    
}