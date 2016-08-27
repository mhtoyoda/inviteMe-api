package br.com.application.resource;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping(value = "/invviteme/authentication")
public class AuthenticationResource {

	private Logger logger = Logger.getLogger(AuthenticationResource.class);
	 
	@Autowired
	private UserBusiness userBusiness;
	
	@RequestMapping(value = "{application}/user", method = RequestMethod.POST)
	public ResponseEntity<Users> validateUser(
			HttpServletRequest request,
			@PathVariable("application") String application, 
			@RequestBody Users users){
			
			try {
				HttpStatus httpStatus = HttpStatus.OK;
				if( null != users ){					
					boolean validateUser = userBusiness.validateUser(users);
					if(!validateUser){
						httpStatus = HttpStatus.UNAUTHORIZED;
						logger.error("Erro Service: AuthenticationResource][validateUser]-> User unauthorized");
			            users.setMessage(new Message().addMessage(httpStatus.value(), httpStatus.getReasonPhrase()));
					}
				}else{
					httpStatus = HttpStatus.BAD_REQUEST;
					logger.error("Erro Service: AuthenticationResource][validateUser]-> User Null Request");
					users = new Users();
		            users.setMessage(new Message().addMessage(httpStatus.value(), httpStatus.getReasonPhrase()));
				}
				return new ResponseEntity<Users>(users, httpStatus);
			} catch (ErrorRepositoryException e) {
				logger.error("Erro Service: AuthenticationResource][validateUser]-> " + e.getMessage());
	            users.setMessage(new Message().addMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
	            return new ResponseEntity<Users>(users, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}
