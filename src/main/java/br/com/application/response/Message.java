package br.com.application.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
        "code",
        "message"
}, namespace = "http://invviteme.com/domain")
public class Message {

	private Integer code = 200;
	private String message = "OK";

	public Message addMessage(Integer code, String message){
		this.code = code;
		this.message = message;
		return this;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
