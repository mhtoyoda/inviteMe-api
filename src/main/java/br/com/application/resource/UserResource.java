package br.com.application.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invviteme/data")
public class UserResource {

	@RequestMapping(value = "user", method = RequestMethod.POST)
	public void createUSer(){
		
	}
}
