package com.jam.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

/**
 * 这里不能用lombok，否则无法注入appprops配置项
 * 
 * @Created by myjamesd.
 * @Copyright (c) 2016, All Rights Reserved.
 */
@Log4j
@Component
@ConfigurationProperties(prefix = "appprops")
public class AppProps {
	public static String host;

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		AppProps.host = host;
	}

}
