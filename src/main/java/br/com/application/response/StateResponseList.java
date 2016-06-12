package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.State;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StateResponseList", propOrder = {
        "states",
        "message"
}, namespace = "http://invviteme.com/domain")
public class StateResponseList {

	private List<State> states;
	private Message message;

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}