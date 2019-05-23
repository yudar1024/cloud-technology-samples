package com.mycompany.myapp.config;

import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfiguration {


//add a group
    @Bean
    public Docket api() throws IOException, URISyntaxException {
        final List<ResponseMessage> globalResponses = Arrays.asList(
            new ResponseMessageBuilder()
                .code(200)
                .message("OK")
                .build(),
            new ResponseMessageBuilder()
                .code(400)
                .message("Bad Request")
                .build(),
            new ResponseMessageBuilder()
                .code(500)
                .message("Internal Error")
                .build());
        final ApiInfo apiInfo = new ApiInfo("REST API","",
            "1.0.0", "", new Contact("team", "", "bla@bla.com"), "", "", Collections.emptyList());
        return new Docket(DocumentationType.SWAGGER_2).groupName("api")
        .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
        .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, globalResponses)
            .globalResponseMessage(RequestMethod.POST, globalResponses)
            .globalResponseMessage(RequestMethod.DELETE, globalResponses)
            .globalResponseMessage(RequestMethod.PATCH, globalResponses)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.mycompany.myapp.web.rest"))
            .build()
            .apiInfo(apiInfo)
            .directModelSubstitute(Temporal.class, String.class);
    }
}
