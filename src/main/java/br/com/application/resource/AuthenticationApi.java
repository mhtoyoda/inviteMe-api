package br.com.application.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.application.token.InitGenerateToken;

@RestController
public class AuthenticationApi {

	@Autowired
	private InitGenerateToken generateToke;
	
	@RequestMapping(value = "/invviteme/api/authentication", method = RequestMethod.POST)
	public ResponseEntity<String> validateUserApi(
			HttpServletRequest request,
			@RequestHeader("typeClient") String typeClient,
			@RequestHeader("username") String username){
			String accessToken = generateToke.generateToken(typeClient, username, request);
		return new ResponseEntity<String>(accessToken, HttpStatus.OK);
	}
}
