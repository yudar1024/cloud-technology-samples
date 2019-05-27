package com.mycompany.myapp.web.rest.examples;

import com.mycompany.myapp.web.rest.AccountResource;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class RolebasedExample {

    private final Logger log = LoggerFactory.getLogger(RolebasedExample.class);


    @GetMapping(value = "/admin")
    @Secured("ROLE_ADMIN")
    public String admin() {
        log.info("admin invoked");
        return "Admin";
    }

    @GetMapping("/user")
    @Secured("ROLE_ROLE1")
    public String user() {
        log.info("role1 invoked");
        return "User";
    }
}
