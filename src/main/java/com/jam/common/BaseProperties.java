package com.jam.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
//@Component
//@Setter @Getter
public class BaseProperties {

    @Value("${com.jam.bbs.siteName}")
    private String siteName;

    @Value("${com.jam.bbs.cookie.name}")
    private String cookieName;

    @Value("${com.jam.bbs.cookie.domain}")
    private String cookieDomain;

    @Value("${com.jam.bbs.session.name}")
    private String sessionName;

}
