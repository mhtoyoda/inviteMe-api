package br.com.application.business;

import java.util.List;

import br.com.application.entity.Event;
import br.com.application.exception.ErrorRepositoryException;

public interface EventBusiness {

    List<Event> eventList() throws ErrorRepositoryException;
    
    boolean isEventExists(Event event);
    
    Event save(Event event) throws ErrorRepositoryException;
    
    Event updateEvent(Event event) throws ErrorRepositoryException;
    
    void delete(Event event) throws ErrorRepositoryException;
    
    Event findOne(Integer id) throws ErrorRepositoryException;
}
