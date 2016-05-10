package br.com.application.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.business.AddressBusiness;
import br.com.application.entity.AddressEvent;

@RestController
@RequestMapping("/invviteme/data")
public class AddressResource {
    
    @Autowired
    private AddressBusiness addressBusiness;

    @RequestMapping(value = "address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AddressEvent>> adressList() {
        try {
            List<AddressEvent> list = addressBusiness.addressList();
            return new ResponseEntity<List<AddressEvent>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<AddressEvent>>(Collections.emptyList(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@RequestMapping(value = "address", method = RequestMethod.POST)
	public void createAddress(AddressEvent addressEvent) {
		System.out.println("Creating Address " + addressEvent.getStreetName());
		
		if(addressEvent.getId() == null || !addressBusiness.isAddressExists(addressEvent)){
			addressBusiness.save(addressEvent);
			System.out.println("Address Created " + addressEvent.getStreetName());
		}else{
			System.out.println("Address Already exists" + addressEvent.getStreetName());
		}		
	}
	
	@RequestMapping(value = "address", method = RequestMethod.PUT)
	public void updateAddress(AddressEvent addressEvent) {
		System.out.println("Updating Address " + addressEvent.getStreetName());
		
		if(addressEvent.getId() != null && addressBusiness.isAddressExists(addressEvent)){
			addressBusiness.save(addressEvent);
			System.out.println("Address Updated " + addressEvent.getStreetName());
		}else{
			System.out.println("Address does not exists" + addressEvent.getStreetName());
		}		
	}
	
	@RequestMapping(value = "address", method = RequestMethod.DELETE)
	public void deleteAddress(AddressEvent addressEvent) {
		System.out.println("Updating Address " + addressEvent.getStreetName());
		
		if(addressEvent.getId() != null && addressBusiness.isAddressExists(addressEvent)){
			addressBusiness.delete(addressEvent);
			System.out.println("Address Deleted " + addressEvent.getStreetName());
		}else{
			System.out.println("Address does not exists" + addressEvent.getStreetName());
		}		
	}
}
