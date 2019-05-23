package com.mycompany.myapp.config;

import io.github.jhipster.config.apidoc.customizer.SwaggerCustomizer;
import io.swagger.models.auth.In;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//refernce to swaggerautoconfiguration JHipsterSwaggerCustomizer example

@Component
public class JwtSwaggerCustomzier implements SwaggerCustomizer, Ordered {

    @Override
    public void customize(Docket docket) {
//        add seucurity sechemae
        docket.securitySchemes(Arrays.asList(new ApiKey("apiKey", HttpHeaders.AUTHORIZATION, In.HEADER.name())));

//        add authorization to header
//        ParameterBuilder headerParameterBuilder = new ParameterBuilder();
//        headerParameterBuilder.name("Authorization")
//            .description("bear token")
//            .modelRef(new ModelRef("string"))
//            .defaultValue("bearer")
//            .required(false);
//        List<Parameter> parameters = new ArrayList<>();
//        parameters.add(headerParameterBuilder.build());
//        docket.globalOperationParameters(parameters);
        docket.securityContexts(Arrays.asList(securityContext()));

    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex("/api/.*"))
            .build();
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("authapi", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
