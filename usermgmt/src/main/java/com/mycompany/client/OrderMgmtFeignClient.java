package com.mycompany.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@AuthorizedFeignClient(name = "ordermgmt", path = "/api")
public interface OrderMgmtFeignClient {

    @RequestMapping(value = "/instanceinfo",method = RequestMethod.GET)
    public String getInfo();
}
