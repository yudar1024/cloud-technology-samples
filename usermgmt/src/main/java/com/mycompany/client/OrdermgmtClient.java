package com.mycompany.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ordermgmt",fallback = OrdermgmtClientFallBack.class)
@AuthorizedFeignClient
public interface OrdermgmtClient {

    @RequestMapping(path = "/api/service/name", method = RequestMethod.GET)
    @HystrixCommand
    String serviceName();


}
