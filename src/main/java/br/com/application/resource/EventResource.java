package br.com.application.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import br.com.application.response.Message;

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
            eventCreated.add(linkTo(methodOn(EventResource.class).findEventById(eventCreated.getEventId())).withSelfRel());
            eventCreated.setMessage(new Message());
            return new ResponseEntity<Event>(eventCreated, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [AddressResource][createAddress]-> " + e.getMessage());
            eventCreated = new Event();
            eventCreated.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
            return new ResponseEntity<Event>(eventCreated, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> findEventById(@PathVariable("id") Integer id) {
        Event event = null;
        try {
        	event = eventBusiness.findOne(id);
            if (null == event) {
            	event = new Event();
                event.setMessage(new Message().addMessage(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase()));
                return new ResponseEntity<Event>(event, HttpStatus.NO_CONTENT);
            }
            event.add(linkTo(methodOn(AddressEventResource.class).findAddressById(event.getAddressEvent().getAddressEventId())).withRel("address"));
            event.setMessage(new Message());
            return new ResponseEntity<Event>(event, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: EventResource][findEventById]-> " + e.getMessage());
            event = new Event();
            event.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
            return new ResponseEntity<Event>(event, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event eventUpdated = null;
        try {
        	eventUpdated = eventBusiness.updateEvent(event);
            if (null == eventUpdated) {
            	eventUpdated = new Event();
            	eventUpdated.setMessage(new Message().addMessage(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase()));
                return new ResponseEntity<Event>(event, HttpStatus.NOT_MODIFIED);
            }
            eventUpdated.setMessage(new Message());
            return new ResponseEntity<Event>(eventUpdated, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [EventResource][updateEvent]-> " + e.getMessage());
            eventUpdated = new Event();
        	eventUpdated.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
            return new ResponseEntity<Event>(eventUpdated, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> deleteEvent(@PathVariable("id") Integer id) {
        Event event = null;
        try {
        	event = eventBusiness.findOne(id);
            if (event != null) {
            	eventBusiness.delete(event);
            }            
            event.setMessage(new Message());
            return new ResponseEntity<Event>(event, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [EventResource][deleteEvent]-> " + e.getMessage());
            event = new Event();
            event.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
            return new ResponseEntity<Event>(event, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
