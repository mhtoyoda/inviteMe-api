package br.com.application.business;

import java.util.List;

import br.com.application.entity.AddressEvent;

public interface AddressBusiness {

    List<AddressEvent> addressList();
    
    boolean isAddressExists(AddressEvent addressEvent);
    
    void save(AddressEvent addressEvent);
    
    void delete(AddressEvent addressEvent);
}
