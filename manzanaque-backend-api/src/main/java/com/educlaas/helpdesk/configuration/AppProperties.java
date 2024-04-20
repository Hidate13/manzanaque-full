package com.educlaas.helpdesk.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private final Auth auth = new Auth();

	public Auth getAuth() {
		return auth;
	}


}
