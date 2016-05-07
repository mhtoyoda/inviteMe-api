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
import br.com.application.entity.State;

@RestController
@RequestMapping("/data")
public class DataApplicantionResource {

	@Autowired
	private DataApplicationBusiness dataApplicationBusiness;
	
	@RequestMapping(value = "state", method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<State>> stateList(){
		try{			
			List<State> stateList = dataApplicationBusiness.stateList();
			return new ResponseEntity<List<State>>(stateList, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<State>>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
