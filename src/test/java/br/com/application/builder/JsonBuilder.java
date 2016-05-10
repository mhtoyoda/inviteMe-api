package br.com.application.builder;

import java.util.Date;

import br.com.application.entity.AddressEvent;
import br.com.application.entity.State;
import br.com.application.entity.StatusType;
import br.com.application.entity.Users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

	public String builderUser(Users user){
		if( user == null ){
			user = new Users();
		}
		user.setName("Ana Carolina");
		user.setLastName("Da Silva");
		user.setEmail("ana.carolina@teste.com.br");
		user.setDateUpdated(new Date());
		user.setGender('F');
		user.setPassword("MPDS@#!2");
		user.setPhoneNumber("1190901020");
		StatusType statusType = new StatusType();
		statusType.setId(1);
		statusType.setDescription("Ativo");
		user.setStatusType(statusType );
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	   public String builderAddress(AddressEvent address){
	        if( address == null ){
	            address = new AddressEvent();
	        }
	        
	        address.setPlaceName("Vila Country");
	        address.setStreetName("Av. Barra Funda");
	        address.setNumber(35);
	        address.setComplement("Terreo");
	        address.setZipCode("123456");
	        address.setCityName("São Paulo");
	        address.setLongitude(1234534L);
            address.setLatitude(-1234534L);
            State state = new State();
            state.setId(10);
            state.setStateName("São Paulo");
            address.setState(state);
	        
	        ObjectMapper mapper = new ObjectMapper();
	        String json = "";
	        try {
	            json = mapper.writeValueAsString(address);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        return json;
	    }
	
	public static void main(String[] args) {
		String jsonUser = new JsonBuilder().builderUser(new Users());
		String jsonAddress = new JsonBuilder().builderAddress(new AddressEvent());

		System.out.println(jsonUser);
		System.out.println(jsonAddress);
	}
}
