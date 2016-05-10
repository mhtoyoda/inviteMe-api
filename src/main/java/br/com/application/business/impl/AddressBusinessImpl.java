package br.com.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.AddressBusiness;
import br.com.application.entity.AddressEvent;
import br.com.application.exception.ErrorRepositoryException;
import br.com.application.repository.AddressRepository;
import br.com.application.repository.StatusTypeRepository;


@Component
public class AddressBusinessImpl implements AddressBusiness{
   
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private StatusTypeRepository statusTypeRepository;
    
    
    @Override
    public List<AddressEvent> addressList(){
        return (List<AddressEvent>) addressRepository.findAll();
    }
   
	@Override
	public boolean isAddressExists(AddressEvent addressEvent) {
		return addressRepository.exists(addressEvent.getId());
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
            addressDeleted = findOne(address.getId());
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
            AddressEvent addressUpdated = findOne(address.getId());
            if(null == addressUpdated){
               return null; 
            }
            
            addressUpdated.setPlaceName(address.getPlaceName());
            addressUpdated.setStreetName(address.getStreetName());
            addressUpdated.setNumber(address.getNumber());
            addressUpdated.setComplement(address.getComplement());
            addressUpdated.setZipCode(address.getZipCode());
            addressUpdated.setCityName(address.getCityName());
            addressUpdated.setLongitude(address.getLongitude());
            addressUpdated.setLatitude(address.getLatitude());
            addressUpdated.setState(address.getState());
            
            return save(addressUpdated);
        }catch(Exception e){
            throw new ErrorRepositoryException(e.getMessage());
        }   
    }
}
