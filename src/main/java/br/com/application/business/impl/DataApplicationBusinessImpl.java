package br.com.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.DataApplicationBusiness;
import br.com.application.entity.EventType;
import br.com.application.entity.EventTypeAccess;
import br.com.application.entity.SocialType;
import br.com.application.entity.State;
import br.com.application.entity.StatusType;
import br.com.application.repository.EventTypeAccessRepository;
import br.com.application.repository.EventTypeRepository;
import br.com.application.repository.SocialTypeRepository;
import br.com.application.repository.StateRepository;
import br.com.application.repository.StatusTypeRepository;

@Component
public class DataApplicationBusinessImpl implements DataApplicationBusiness {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private EventTypeAccessRepository eventTypeAccessRepository;
	
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Autowired
	private SocialTypeRepository socialTypeRepository;
	
	@Autowired
	private StatusTypeRepository statusTypeRepository;
	
	@Override
	public List<State> stateList(){
		return stateRepository.findAll();
	}
	
	@Override
	public List<EventTypeAccess> eventTypeAccessList(){
		return eventTypeAccessRepository.findAll();
	}
	
	@Override
	public List<EventType> eventTypeList(){
		return eventTypeRepository.findAll();
	}
	
	@Override
	public List<SocialType> socialTypeList(){
		return socialTypeRepository.findAll();
	}
	
	@Override
	public List<StatusType> statusTypeList(){
		return statusTypeRepository.findAll();
	}
}