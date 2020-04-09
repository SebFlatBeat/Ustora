package com.Ustora.springadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class SpringAdminApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringAdminApplication.class);

	public static void main(String[] args) {

		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error log message");

		SpringApplication.run(SpringAdminApplication.class, args);
	}

}
