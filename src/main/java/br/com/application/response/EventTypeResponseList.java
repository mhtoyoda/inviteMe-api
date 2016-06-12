package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.EventType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTypeResponseList", propOrder = {
        "eventTypes",
        "message"
}, namespace = "http://invviteme.com/domain")
public class EventTypeResponseList {

	private List<EventType> eventTypes;
	private Message message;

	public List<EventType> getEventTypes() {
		return eventTypes;
	}

	public void setEventTypes(List<EventType> eventTypes) {
		this.eventTypes = eventTypes;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}