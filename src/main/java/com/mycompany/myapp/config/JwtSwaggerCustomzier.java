package com.mycompany.myapp.config;

import io.github.jhipster.config.apidoc.customizer.SwaggerCustomizer;
import io.swagger.models.auth.In;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;


//refernce to swaggerautoconfiguration JHipsterSwaggerCustomizer example

@Component
public class JwtSwaggerCustomzier implements SwaggerCustomizer, Ordered {

    @Override
    public void customize(Docket docket) {
//        add seucurity sechemae
        docket.securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
