package br.com.application.builder;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.application.entity.StatusType;
import br.com.application.entity.Users;

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
	
	public static void main(String[] args) {
		String json = new JsonBuilder().builderUser(new Users());
		System.out.println(json);
	}
}
