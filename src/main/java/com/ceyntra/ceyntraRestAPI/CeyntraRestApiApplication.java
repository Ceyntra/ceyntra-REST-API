package com.ceyntra.ceyntraRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CeyntraRestApiApplication {



	public static void main(String[] args) {
		SpringApplication.run(CeyntraRestApiApplication.class, args);
	}

}
