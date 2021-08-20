package com.ceyntra.ceyntraRestAPI;

import com.ceyntra.ceyntraRestAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CeyntraRestApiApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(CeyntraRestApiApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
	emailService.sendEmail("shehansandeepa82@gmail.com", "This is test email", "Password Reset email from ceyntra");
	}

}
