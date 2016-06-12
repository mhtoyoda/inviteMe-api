package br.com.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.AddressBusiness;
import br.com.application.entity.AddressEvent;
import br.com.application.entity.State;
import br.com.application.exception.ErrorRepositoryException;
import br.com.application.repository.AddressRepository;
import br.com.application.repository.StateRepository;


@Component
public class AddressBusinessImpl implements AddressBusiness{
   
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private StateRepository stateRepository;
    
    
    @Override
    public List<AddressEvent> addressList(){
        return (List<AddressEvent>) addressRepository.findAll();
    }
   
	@Override
	public boolean isAddressExists(AddressEvent addressEvent) {
		return addressRepository.exists(addressEvent.getAddressEventId());
	}

    @Override
    public AddressEvent save(AddressEvent addressEvent) throws ErrorRepositoryException {
        try{
            return addressRepository.save(addressEvent);
        }catch(Exception e){
            throw new ErrorRepositoryException(e.getMessage());
        }   
    }

	@Override
	public void delete(AddressEvent address) throws ErrorRepositoryException{
	    AddressEvent addressDeleted;
        try {
            addressDeleted = findOne(address.getAddressEventId());
            if(addressDeleted != null){
                addressRepository.delete(addressDeleted);   
            }
        } catch (ErrorRepositoryException e) {
            throw new ErrorRepositoryException(e.getMessage());
        }
	}

	@Override
    public AddressEvent findOne(Integer id) throws ErrorRepositoryException {
        try{
            AddressEvent addressEvent = addressRepository.findOne(id);
            return addressEvent;
        }catch(Exception e){
            throw new ErrorRepositoryException(e.getMessage());
        }
    }
	
	@Override
    public AddressEvent updateAddress(AddressEvent address) throws ErrorRepositoryException{
        try{
            AddressEvent addressFind = findOne(address.getAddressEventId());
            if(null == addressFind){
               return null; 
            }
            State state = stateRepository.findOne(address.getState().getId());
            AddressEvent addressUpdated = new AddressEvent(address.getPlaceName(), address.getStreetName(), address.getNumber(),
            		address.getComplement(), address.getZipCode(), address.getCityName(),
            		address.getLongitude(), address.getLatitude(), state);            
            addressUpdated.setAddressEventId(address.getAddressEventId());                        
            return save(addressUpdated);
        }catch(Exception e){
            throw new ErrorRepositoryException(e.getMessage());
        }   
    }
}