package br.com.application.business;

import java.util.List;

import br.com.application.entity.AddressEvent;
import br.com.application.exception.ErrorRepositoryException;

public interface AddressBusiness {

    List<AddressEvent> addressList();
    
    boolean isAddressExists(AddressEvent addressEvent);
    
    AddressEvent save(AddressEvent addressEvent)  throws ErrorRepositoryException;
    
    AddressEvent updateAddress(AddressEvent addressEvent) throws ErrorRepositoryException;
    
    void delete(AddressEvent addressEvent) throws ErrorRepositoryException;
    
    AddressEvent findOne(Integer id) throws ErrorRepositoryException;
}
