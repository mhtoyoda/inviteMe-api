package br.com.application.resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.business.AddressBusiness;
import br.com.application.entity.AddressEvent;
import br.com.application.exception.ErrorRepositoryException;
import br.com.application.response.Message;

@RestController
@RequestMapping("/invviteme/address")
public class AddressEventResource {

    private Logger logger = Logger.getLogger(AddressEventResource.class);

    @Autowired
    private AddressBusiness addressBusiness;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressEvent> findAddressById(@PathVariable("id") Integer id) {
        AddressEvent addressEvent = null;
        try {
            addressEvent = addressBusiness.findOne(id);
            if (null == addressEvent) {
            	addressEvent = new AddressEvent();
            	addressEvent.setMessage(new Message());
                return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.NO_CONTENT);
            }
            addressEvent.setMessage(new Message().addMessage(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()));
            return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: AddressResource][findAddressById]-> " + e.getMessage());
            addressEvent = new AddressEvent();
            addressEvent.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
            return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}