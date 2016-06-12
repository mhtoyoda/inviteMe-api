package br.com.application.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
            eventCreated.add(linkTo(methodOn(EventResource.class, findEventById(eventCreated.getEventId()))).withSelfRel());
            return new ResponseEntity<Event>(eventCreated, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [AddressResource][createAddress]-> " + e.getMessage());
            return new ResponseEntity<Event>(eventCreated, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> findEventById(@PathVariable("id") Integer id) {
        Event event = null;
        try {
        	event = eventBusiness.findOne(id);
            if (null == event) {
                return new ResponseEntity<Event>(event, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<Event>(event, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: EventResource][findEventById]-> " + e.getMessage());
            return new ResponseEntity<Event>(event, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> eventList() {
        try {
            List<Event> list = eventBusiness.eventList();
            return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Event>>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event eventUpdated = null;
        try {
        	eventUpdated = eventBusiness.updateEvent(event);
            if (null == eventUpdated) {
                return new ResponseEntity<Event>(event, HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<Event>(event, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [EventResource][updateEvent]-> " + e.getMessage());
            return new ResponseEntity<Event>(event, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEvent(@PathVariable("id") Integer id) {
        Event event = null;
        try {
        	event = eventBusiness.findOne(id);
            if (event != null) {
            	eventBusiness.delete(event);
            }
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [EventResource][deleteEvent]-> " + e.getMessage());
        }
    }
}
