package br.com.application.builder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import br.com.application.data.StatusData;
import br.com.application.entity.AddressEvent;
import br.com.application.entity.State;
import br.com.application.entity.StatusType;
import br.com.application.entity.Users;
import br.com.application.security.PasswordManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

	public String builderUser() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		StatusType statusType = new StatusType(StatusData.PENDENTE);
		String password = PasswordManager.encrypt("admin123@");
		Users user = new Users("Ana Carolina", "Da Silva", LocalDate.of(1980,
				10, 2), "1190901020", "ana.carolina@teste.com.br", password,
				'F', statusType);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String builderAddress() {
		State state = new State("São Paulo", "Brasil");
		state.setId(25);
		AddressEvent address = new AddressEvent("Vila Country",
				"Av. Barra Funda", 35, "Terreo", "123456", "São Paulo",
				1234534L, -1234534L, state);

		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(address);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String jsonUser = new JsonBuilder().builderUser();
		String jsonAddress = new JsonBuilder().builderAddress();
		System.out.println(PasswordManager.encrypt("admin123@"));
		System.out.println(jsonUser);
		System.out.println(jsonAddress);
	}
}
