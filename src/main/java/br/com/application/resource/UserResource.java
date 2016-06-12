package br.com.application.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

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
import br.com.application.response.Message;
import br.com.application.response.UserResponseList;

import com.google.common.collect.Lists;

@RestController
@RequestMapping("/invviteme/user")
public class UserResource {

	private Logger logger = Logger.getLogger(UserResource.class);

	@Autowired
	private UserBusiness userBusiness;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		Users userCreated = null;
		try {
			userCreated = userBusiness.save(user);
			userCreated.add(linkTo(methodOn(UserResource.class).findUserById(userCreated.getUserId())).withSelfRel());			
			userCreated.setMessage(new Message());
			return new ResponseEntity<Users>(userCreated, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][createUSer]-> "+ e.getMessage());
			userCreated = new Users();
			userCreated.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<Users>(userCreated, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> findUserById(@PathVariable("id") Integer id) {
		Users user = null;
		try {
			user = userBusiness.findOne(id);
			if (null == user) {
				user = new Users();
				user.setMessage(new Message().addMessage(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase()));
				return new ResponseEntity<Users>(user, HttpStatus.NO_CONTENT);
			}
			user.setMessage(new Message());
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][findUserById]-> "+ e.getMessage());
			user = new Users();
			user.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<Users>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, 
					produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> updateUser(@RequestBody Users user) {
		Users userUpdated = null;
		try {
			userUpdated = userBusiness.updateUser(user);
			if( null == userUpdated ){				
				user.setMessage(new Message().addMessage(HttpStatus.NOT_MODIFIED.value(), HttpStatus.NOT_MODIFIED.getReasonPhrase()));
				return new ResponseEntity<Users>(user, HttpStatus.NOT_MODIFIED);
			}
			userUpdated.setMessage(new Message());
			return new ResponseEntity<Users>(userUpdated, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][updateUser]-> "+ e.getMessage());
			userUpdated = new Users();
			userUpdated.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<Users>(userUpdated, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseList> findAllUsers() {
		List<Users> list = Lists.newArrayList();
		UserResponseList userList = new UserResponseList();
		try {
			list = userBusiness.listAll();
			if (list.isEmpty()) {
				userList.setMessage(new Message().addMessage(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase()));
				return new ResponseEntity<UserResponseList>(userList, HttpStatus.NO_CONTENT);
			}
			userList.setUsers(list);
			userList.setMessage(new Message());			
			return new ResponseEntity<UserResponseList>(userList, HttpStatus.OK);
		} catch (ErrorRepositoryException e) {
			logger.error("Erro Service: [UserResource][findAllUsers]-> "+ e.getMessage());
			userList.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
			return new ResponseEntity<UserResponseList>(userList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}