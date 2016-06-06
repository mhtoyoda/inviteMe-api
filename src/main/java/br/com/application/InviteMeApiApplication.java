package br.com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class InviteMeApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(InviteMeApiApplication.class, args);
	}
}
