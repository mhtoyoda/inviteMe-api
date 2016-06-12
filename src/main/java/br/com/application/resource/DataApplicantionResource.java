package br.com.application.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.business.DataApplicationBusiness;
import br.com.application.entity.EventType;
import br.com.application.entity.EventTypeAccess;
import br.com.application.entity.SocialType;
import br.com.application.entity.State;
import br.com.application.entity.StatusType;
import br.com.application.response.EventTypeAccessResponseList;
import br.com.application.response.EventTypeResponseList;
import br.com.application.response.Message;
import br.com.application.response.SocialTypeResponseList;
import br.com.application.response.StateResponseList;
import br.com.application.response.StatusTypeResponseList;

@RestController
@RequestMapping("/invviteme/data")
public class DataApplicantionResource {

	@Autowired
	private DataApplicationBusiness dataApplicationBusiness;

	@RequestMapping(value = "/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StateResponseList> stateList() {
		StateResponseList stateResponseList = new StateResponseList();
		try {
			List<State> list = dataApplicationBusiness.stateList();
			stateResponseList.setStates(list);
			stateResponseList.setMessage(new Message());
			return new ResponseEntity<StateResponseList>(stateResponseList, HttpStatus.OK);
		} catch (Exception e) {
			stateResponseList.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<StateResponseList>(stateResponseList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/eventTypeAccess", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventTypeAccessResponseList> eventTypeAccessList() {
		EventTypeAccessResponseList eventTypeAccessResponseList = new EventTypeAccessResponseList();
		try {
			 List<EventTypeAccess> list = dataApplicationBusiness.eventTypeAccessList();
			 eventTypeAccessResponseList.setEventTypeAccesses(list);
			 eventTypeAccessResponseList.setMessage(new Message());
			return new ResponseEntity<EventTypeAccessResponseList>(eventTypeAccessResponseList, HttpStatus.OK);
		} catch (Exception e) {
			eventTypeAccessResponseList.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<EventTypeAccessResponseList>(eventTypeAccessResponseList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/eventType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventTypeResponseList> eventTypeList() {
		EventTypeResponseList eventTypeResponseList = new EventTypeResponseList();
		try {
			List<EventType> list = dataApplicationBusiness.eventTypeList();
			eventTypeResponseList.setEventTypes(list);
			eventTypeResponseList.setMessage(new Message());
			return new ResponseEntity<EventTypeResponseList>(eventTypeResponseList, HttpStatus.OK);
		} catch (Exception e) {
			eventTypeResponseList.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<EventTypeResponseList>(eventTypeResponseList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/socialType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SocialTypeResponseList> socialTypeList() {
		SocialTypeResponseList socialTypeResponseList = new SocialTypeResponseList();
		try {
			List<SocialType> list = dataApplicationBusiness.socialTypeList();
			socialTypeResponseList.setSocialTypes(list);
			socialTypeResponseList.setMessage(new Message());
			return new ResponseEntity<SocialTypeResponseList>(socialTypeResponseList, HttpStatus.OK);
		} catch (Exception e) {
			socialTypeResponseList.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<SocialTypeResponseList>(socialTypeResponseList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/statusType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusTypeResponseList> statusTypeList() {
		StatusTypeResponseList statusTypeResponseList = new StatusTypeResponseList();
		try {
			List<StatusType> list = dataApplicationBusiness.statusTypeList();
			statusTypeResponseList.setStatusTypes(list);
			statusTypeResponseList.setMessage(new Message());
			return new ResponseEntity<StatusTypeResponseList>(statusTypeResponseList, HttpStatus.OK);
		} catch (Exception e) {
			statusTypeResponseList.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<StatusTypeResponseList>(statusTypeResponseList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}