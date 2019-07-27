package com.mycompany.myapp.constants;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

public enum MyRoles {
    ROLE_ADMIN("roles.admin"),
    ROLE_USER("roles.user");


    private ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

    private String displayCode;

    MyRoles(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getValue(){

        return messageSource.getMessage(displayCode,null, LocaleContextHolder.getLocale());
    }

}