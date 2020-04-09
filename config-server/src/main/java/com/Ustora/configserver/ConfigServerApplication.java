package com.Ustora.configserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	private static Logger logger = LoggerFactory.getLogger(ConfigServerApplication.class);

	public static void main(String[] args) {

		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error log message");
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
