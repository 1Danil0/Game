package com.danilermolenko.spring.game.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaWeb extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{JavaConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
