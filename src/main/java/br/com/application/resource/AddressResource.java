package br.com.application.resource;

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

import br.com.application.business.AddressBusiness;
import br.com.application.entity.AddressEvent;
import br.com.application.exception.ErrorRepositoryException;

@RestController
@RequestMapping("/invviteme/data")
public class AddressResource {

    private Logger logger = Logger.getLogger(AddressResource.class);

    @Autowired
    private AddressBusiness addressBusiness;

    @RequestMapping(value = "address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AddressEvent>> adressList() {
        try {
            List<AddressEvent> list = addressBusiness.addressList();
            return new ResponseEntity<List<AddressEvent>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<AddressEvent>>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressEvent> findAddressById(@PathVariable("id") Integer id) {
        AddressEvent addressEvent = null;
        try {
            addressEvent = addressBusiness.findOne(id);
            if (null == addressEvent) {
                return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: AddressResource][findAddressById]-> " + e.getMessage());
            return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "address", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressEvent> createAddress(@RequestBody AddressEvent addressEvent) {
        AddressEvent addressCreated = null;

        try {
            addressCreated = addressBusiness.save(addressEvent);
            return new ResponseEntity<AddressEvent>(addressCreated, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [AddressResource][createAddress]-> " + e.getMessage());
            return new ResponseEntity<AddressEvent>(addressCreated, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "address", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressEvent> updateAddress(@RequestBody AddressEvent addressEvent) {
        AddressEvent addressUpdated = null;
        try {
            addressUpdated = addressBusiness.updateAddress(addressEvent);
            if (null == addressUpdated) {
                return new ResponseEntity<AddressEvent>(addressEvent, HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<AddressEvent>(addressUpdated, HttpStatus.OK);
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [AddressResource][updateAddress]-> " + e.getMessage());
            return new ResponseEntity<AddressEvent>(addressUpdated, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "address/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAddress(@PathVariable("id") Integer id) {
        AddressEvent addressEvent = null;
        try {
            addressEvent = addressBusiness.findOne(id);
            if (addressEvent != null) {
                addressBusiness.delete(addressEvent);
            }
        } catch (ErrorRepositoryException e) {
            logger.error("Erro Service: [AddressResource][deleteAddress]-> " + e.getMessage());
        }
    }
}