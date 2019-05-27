package com.mycompany.myapp.web.rest.examples;

import com.mycompany.myapp.web.rest.AccountResource;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import org.keycloak.KeycloakSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")

public class RolebasedExample {

    private final Logger log = LoggerFactory.getLogger(RolebasedExample.class);


    @GetMapping(value = "/admin")
    @Secured("ROLE_ADMIN")
    public String admin(HttpServletRequest request) {
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        String userName = keycloakSecurityContext.getToken().getPreferredUsername();

        log.info("user name = "+userName);
        log.info("user in security context  = "+SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
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
