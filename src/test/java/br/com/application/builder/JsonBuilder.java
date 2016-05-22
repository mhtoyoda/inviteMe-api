package br.com.application.builder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.application.data.GenderData;
import br.com.application.entity.AddressEvent;
import br.com.application.entity.State;
import br.com.application.entity.Users;
import br.com.application.security.PasswordManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

	public String builderUser() throws NoSuchAlgorithmException, UnsupportedEncodingException{		
		Users user = new Users("Ana Carolina", "Da Silva", "1190901020", "ana.carolina@teste.com.br", GenderData.FEMALE);		
		user.alterPassword(PasswordManager.encrypt("admin123"));		
		
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
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String jsonUser = new JsonBuilder().builderUser();
		String jsonAddress = new JsonBuilder().builderAddress(new AddressEvent());

		System.out.println(jsonUser);
		System.out.println(jsonAddress);
	}
}
