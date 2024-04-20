package com.educlaas.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.educlaas.helpdesk.configuration.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties (AppProperties.class)
public class ManzanaqueHelpdeskSystem {

	public static void main(String[] args) {
		SpringApplication.run(ManzanaqueHelpdeskSystem.class, args);
	}

}
