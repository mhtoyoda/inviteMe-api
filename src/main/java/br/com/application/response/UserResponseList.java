package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.Users;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserResponseList", propOrder = {
        "users",
        "message"
}, namespace = "http://invviteme.com/domain")
public class UserResponseList {

	private List<Users> users;
	private Message message;

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
