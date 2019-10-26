package com.mycompany.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ordermgmt")
@AuthorizedFeignClient
public interface OrdermgmtClient {

    @RequestMapping(path = "/api/service/name", method = RequestMethod.GET)
    String serviceName();
}
