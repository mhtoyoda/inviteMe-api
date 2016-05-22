package br.com.application.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.business.UserBusiness;
import br.com.application.entity.Users;
import br.com.application.exception.ErrorRepositoryException;

import com.google.common.collect.Lists;

@RestController
@RequestMapping("/invviteme/data")
public class UserResource {

	private Logger logger = Logger.getLogger(UserResource.class);

	@Autowired
	private UserBusiness userBusiness;

	@RequestMapping(value = "user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		Users userCreated = null;
		try {
			userCreated = userBusiness.save(user);
			return new ResponseEntity<Users>(userCreated, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][createUSer]-> "+ e.getMessage());
			return new ResponseEntity<Users>(userCreated, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> findUserById(@PathVariable("id") Integer id) {
		Users user = null;
		try {
			user = userBusiness.findOne(id);
			if (null == user) {
				return new ResponseEntity<Users>(user, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][findUserById]-> "+ e.getMessage());
			return new ResponseEntity<Users>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "user", method = RequestMethod.PUT, 
					produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> updateUser(@RequestBody Users user) {
		Users userUpdated = null;
		try {
			userUpdated = userBusiness.updateUser(user);
			if( null == userUpdated ){
				return new ResponseEntity<Users>(user, HttpStatus.NOT_MODIFIED);
			}
			return new ResponseEntity<Users>(userUpdated, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][updateUser]-> "+ e.getMessage());
			return new ResponseEntity<Users>(userUpdated, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Users>> findAllUsers() {
		List<Users> list = Lists.newArrayList();
		try {
			list = userBusiness.listAll();
			if (list.isEmpty()) {
				return new ResponseEntity<List<Users>>(list, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][findAllUsers]-> "+ e.getMessage());
			return new ResponseEntity<List<Users>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}