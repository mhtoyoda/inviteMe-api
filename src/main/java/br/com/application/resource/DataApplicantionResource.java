package br.com.application.resource;

import java.util.Collections;
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

@RestController
@RequestMapping("/data")
public class DataApplicantionResource {

	@Autowired
	private DataApplicationBusiness dataApplicationBusiness;

	@RequestMapping(value = "state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> stateList() {
		try {
			List<State> list = dataApplicationBusiness.stateList();
			return new ResponseEntity<List<State>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<State>>(Collections.emptyList(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "eventTypeAccess", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventTypeAccess>> eventTypeAccessList() {
		try {
			List<EventTypeAccess> list = dataApplicationBusiness.eventTypeAccessList();
			return new ResponseEntity<List<EventTypeAccess>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<EventTypeAccess>>(Collections.emptyList(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "eventType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventType>> eventTypeList() {
		try {
			List<EventType> list = dataApplicationBusiness.eventTypeList();
			return new ResponseEntity<List<EventType>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<EventType>>(Collections.emptyList(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "socialType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SocialType>> socialTypeList() {
		try {
			List<SocialType> list = dataApplicationBusiness.socialTypeList();
			return new ResponseEntity<List<SocialType>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SocialType>>(Collections.emptyList(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "statusType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StatusType>> statusTypeList() {
		try {
			List<StatusType> list = dataApplicationBusiness.statusTypeList();
			return new ResponseEntity<List<StatusType>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<StatusType>>(Collections.emptyList(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}