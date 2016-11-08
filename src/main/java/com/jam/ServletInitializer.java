package com.jam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CsApplication.class);
	}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServletInitializer.class, args);
    }
}