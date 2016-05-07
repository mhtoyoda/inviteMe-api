package br.com.application.business;

import java.util.List;

import br.com.application.entity.EventType;
import br.com.application.entity.EventTypeAccess;
import br.com.application.entity.SocialType;
import br.com.application.entity.State;
import br.com.application.entity.StatusType;

public interface DataApplicationBusiness {

	List<State> stateList();

	List<EventTypeAccess> eventTypeAccessList();

	List<EventType> eventTypeList();

	List<SocialType> socialTypeList();

	List<StatusType> statusTypeList();

}
