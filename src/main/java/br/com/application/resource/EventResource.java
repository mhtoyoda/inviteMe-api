package br.com.application.resource;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.entity.Users;

@RestController
@RequestMapping("/invviteme/event")
public class EventResource {

	private Logger logger = Logger.getLogger(EventResource.class);
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, 
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createEvent(@RequestBody Users user){
		logger.info("Criação de Evento "+user);
		
	}
}
