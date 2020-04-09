package com.Ustora.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.Ustora.user")
@EnableDiscoveryClient
public class UserApplication {

	private static Logger logger = LoggerFactory.getLogger(UserApplication.class);

	public static void main(String[] args) {

		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error log message");

		SpringApplication.run(UserApplication.class, args);
	}

}
