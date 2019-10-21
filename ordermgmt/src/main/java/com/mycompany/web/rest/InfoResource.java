package com.mycompany.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoResource {

    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    @RequestMapping(value = "/instanceinfo",method = RequestMethod.GET)
    public String getServiceName(){
        return applicationName;
    }
}
