package com.team3.LMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);
    public static int LIMIT = 5; 

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
