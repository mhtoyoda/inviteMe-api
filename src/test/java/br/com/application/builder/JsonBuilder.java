package br.com.application.builder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.application.data.StatusData;
import br.com.application.entity.AddressEvent;
import br.com.application.entity.Event;
import br.com.application.entity.EventType;
import br.com.application.entity.EventTypeAccess;
import br.com.application.entity.State;
import br.com.application.entity.StatusType;
import br.com.application.entity.Users;
import br.com.application.security.PasswordManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonBuilder {

    public String builderUser() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StatusType statusType = new StatusType(StatusData.PENDENTE);
        String password = PasswordManager.encrypt("admin123@");
        Users user = new Users("Ana Carolina", "Da Silva", LocalDate.of(1980, 10, 2), "1190901020", "ana.carolina@teste.com.br", password, 'F', statusType);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String json = "";
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String builderAddress() {
        State state = new State("Sao Paulo", "Brasil");
        state.setId(25);
        AddressEvent address = new AddressEvent("Vila Country", "Av. Barra Funda", 35, "Terreo", "123456", "Sao Paulo", 1234534L, -1234534L, state);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String json = "";
        try {
            json = mapper.writeValueAsString(address);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String builderEvent() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StatusType statusType = new StatusType(StatusData.PENDENTE);
        String password = PasswordManager.encrypt("admin123@");

        Users owner = new Users("Ana Carolina", "Da Silva", LocalDate.of(1980, 10, 2), "1190901020", "ana.carolina@teste.com.br", password, 'F', statusType);
        owner.setId(1);

        EventTypeAccess eventTypeAccess = new EventTypeAccess("Publico");
        eventTypeAccess.setId(1);

        EventType eventType = new EventType("Curso", statusType);
        eventType.setId(2);

        State state = new State("Sao Paulo", "Brasil");
        state.setId(25);
        
        AddressEvent addressEvent = new AddressEvent("Vila Country", "Av. Barra Funda", 35, "Terreo", "123456", "Sao Paulo", 1234534L, -1234534L, state);
        addressEvent.setId(1);
        
        Event event = new Event(owner, eventTypeAccess, eventType, "Evento do Ano", "Evento para Confraternizar o sucesso do Invvite me", "observacao", 1000,
                                addressEvent, statusType, LocalDateTime.of(2016, 6, 20, 19, 30), LocalDateTime.of(2016, 6, 21, 4, 30), true, true, false);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String json = "";
        try {
            json = mapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String jsonUser = new JsonBuilder().builderUser();
        String jsonAddress = new JsonBuilder().builderAddress();
        String jsonEvent = new JsonBuilder().builderEvent();
        System.out.println(PasswordManager.encrypt("admin123@"));
        System.out.println(jsonUser);
        System.out.println(jsonAddress);
        System.out.println(jsonEvent);
    }
}
