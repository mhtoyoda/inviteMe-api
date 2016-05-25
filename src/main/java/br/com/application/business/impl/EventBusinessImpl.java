package br.com.application.business.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.EventBusiness;
import br.com.application.data.StatusData;
import br.com.application.entity.AddressEvent;
import br.com.application.entity.Event;
import br.com.application.entity.EventType;
import br.com.application.entity.EventTypeAccess;
import br.com.application.entity.StatusType;
import br.com.application.entity.Users;
import br.com.application.exception.ErrorRepositoryException;
import br.com.application.repository.EventRepository;
import br.com.application.repository.StatusTypeRepository;

import com.google.common.collect.Lists;

@Component
public class EventBusinessImpl implements EventBusiness {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private StatusTypeRepository statusTypeRepository;
	
	@Override
	public Event save(Event event) throws ErrorRepositoryException {
		try{
			return eventRepository.save(event);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}

	@Override
	public Event findOne(Integer id) throws ErrorRepositoryException {
		try{
		    Event event = eventRepository.findOne(id);
			return event;
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}
	}
	
	@Override
	public Event updateEvent(Event event) throws ErrorRepositoryException{
		try{
		    Event eventFind = findOne(event.getId());
			if(null == eventFind){
			   return null;	
			}
			StatusType statusType = statusTypeRepository.findOne(StatusData.PENDENTE.getId());
			Event eventUpdated = new Event(event.getOwner(), event.getEventTypeAccess(),
                            	            event.getEventType(), event.getTitle(), event.getDescription(),
                            	            event.getLimitGuests(), event.getAddressEvent(),
                            	            statusType, event.getEventInitHour(),
                            	            event.getEventEndHour(), true,
                            	            event.isCanSendInviteExternal(), event.isEventForFree());
			
			
			eventUpdated.setId(event.getId());
			return save(eventUpdated);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}
	
	@Override
	public List<Event> eventList() throws ErrorRepositoryException{
		try{
			Iterable<Event> list = eventRepository.findAll();
			return Lists.newArrayList(list);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}
	}

    @Override
    public boolean isEventExists(Event event) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Event event) throws ErrorRepositoryException {
        // TODO Auto-generated method stub
        
    }
}