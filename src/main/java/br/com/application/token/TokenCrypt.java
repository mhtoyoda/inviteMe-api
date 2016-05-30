package br.com.application.token;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TokenCrypt {

	private final static Logger logger = Logger.getLogger(TokenCrypt.class);
	
	private final String keySecret = "0123456789abcdef";
	private final String IV = "CYWSAHTWAXOUAELS";
	
	public String encrypt(String value) {
		try{			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec key = new SecretKeySpec(keySecret.getBytes("UTF-8"), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
			byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));		
			return DatatypeConverter.printBase64Binary(encrypted);
		}catch(Exception e){
			logger.error("Erro [Crypt].[encrypt] - value: "+value + " - "+e.getMessage());
		}
		return value;
	}

	public String decrypt(String value) {
		byte[] encrytedBytes = DatatypeConverter.parseBase64Binary(value);
		try{
			Cipher decript = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec key = new SecretKeySpec(keySecret.getBytes("UTF-8"), "AES");
			decript.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
			return new String(decript.doFinal(encrytedBytes), "UTF-8");
		}catch(Exception e){
			logger.error("Erro [Crypt].[decrypt] - value: "+value + " - "+e.getMessage());
		}
		return value;		
	}
}