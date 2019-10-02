package com.mycompany.web.rest;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.mycompany.client.OrderMgmtFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@NacosPropertySource(dataId = "usermgmt-dev.properties", autoRefreshed = true)
@RefreshScope
public class InfoResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);


    @Autowired
    private OrderMgmtFeignClient orderMgmtFeignClient;

    @Value("${usermgmt.config.hello:fromlocal}")
    private String hello;
    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    @RequestMapping(value = "/instanceinfo",method = RequestMethod.GET)
    public String getServiceName(){
        return applicationName;
    }

    @RequestMapping(value = "/feigninfo",method = RequestMethod.GET)
    public String getfiegnName(){
        log.info("try get ordermgmt instance app name");
        String result= orderMgmtFeignClient.getInfo();
        log.info("resutl = {1}",result);
        return result;
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String getNacosProperties(){
        return hello;
    }

}
