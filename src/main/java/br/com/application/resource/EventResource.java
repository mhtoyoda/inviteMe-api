package br.com.application.resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.business.EventBusiness;
import br.com.application.entity.Event;
import br.com.application.exception.ErrorRepositoryException;

@RestController
@RequestMapping("/invviteme/event")
public class EventResource {

    private Logger logger = Logger.getLogger(EventResource.class);
    
    @Autowired
    private EventBusiness eventBusiness;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        logger.info("Criação de Evento " + event);
        
        Event eventCreated = null;

        try {
            eventCreated = eventBusiness.save(event);
            return new ResponseEntity<Event>(eventCreated, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [AddressResource][createAddress]-> " + e.getMessage());
            return new ResponseEntity<Event>(eventCreated, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
