package br.com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import br.com.application.token.InitGenerateToken;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class InviteMeApiApplication {

	@Autowired
	private InitGenerateToken generateToken;
	
	public static void main(String[] args) {
		SpringApplication.run(InviteMeApiApplication.class, args);
	}
}
