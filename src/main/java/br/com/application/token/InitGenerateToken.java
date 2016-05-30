package br.com.application.token;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitGenerateToken {
	
	private final static Logger log = Logger.getLogger(InitGenerateToken.class);
	
	@Autowired
	private TokenCrypt tokenCrypt;
	
	/**
	 * Gera AccessToken de acordo com parametros de request
	 * @param typeClient
	 * @param username
	 * @param request
	 * @return chave criptografada
	 */
	public String generateToken(String typeClient, String username, HttpServletRequest request){
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String dateTimeNow = getDateTimeNow();
		String accessToken = String.format("%s|%s|%s|%s|%s", typeClient, uri, method, dateTimeNow, username);
		log.info("Logger Word to Crypt "+accessToken);
		return tokenCrypt.encrypt(accessToken);
	}

	private String getDateTimeNow() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm").withLocale(new Locale("pt", "br"));
		return now.format(formatter);
	}
}
