package br.com.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.AddressBusiness;
import br.com.application.entity.AddressEvent;
import br.com.application.repository.AddressRepository;


@Component
public class AddressBusinessImpl implements AddressBusiness{
   
    @Autowired
    private AddressRepository addressRepository;
    
    @Override
    public List<AddressEvent> addressList(){
        return (List<AddressEvent>) addressRepository.findAll();
    }
   
	@Override
	public boolean isAddressExists(AddressEvent addressEvent) {
		return addressRepository.exists(addressEvent.getId());
	}

	@Override
	public void save(AddressEvent addressEvent) {
		addressRepository.save(addressEvent);		
	}

	@Override
	public void delete(AddressEvent addressEvent) {
		addressRepository.delete(addressEvent);				
	}
}
