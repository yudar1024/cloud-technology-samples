package com.mycompany.myapp.web.rest.examples;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolebasedExample {
    @GetMapping(value = "/admin")
    @Secured("ROLE_admin")
    public String admin() {
        return "Admin";
    }

    @GetMapping("/user")
    @Secured("ROLE_role1")
    public String user() {
        return "User";
    }
}
