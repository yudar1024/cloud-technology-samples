package com.mycompany.web.rest;

//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope
//@NacosPropertySource(dataId = "gateway-dev.properties", autoRefreshed = true)
public class InfoResource {

    @Value("${jhipster.clientApp.name:gateway}")
    private String applicationName;

    @Value("${gateway.config.hello:fromlocal}")
    private String hello;

    @RequestMapping(value = "/instanceinfo",method = RequestMethod.GET)
    public String getServiceName(){
        return applicationName;
    }

    @RequestMapping(value = "/nacosinfo", method = RequestMethod.GET)
    public String getNacosProperties(){
        return hello;
    }
}
