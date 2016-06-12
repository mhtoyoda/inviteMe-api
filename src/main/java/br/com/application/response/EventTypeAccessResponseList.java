package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.EventTypeAccess;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTypeAccessResponseList", propOrder = {
        "eventTypeAccesses",
        "message"
}, namespace = "http://invviteme.com/domain")
public class EventTypeAccessResponseList {

	private List<EventTypeAccess> eventTypeAccesses;
	private Message message;

	public List<EventTypeAccess> getEventTypeAccesses() {
		return eventTypeAccesses;
	}

	public void setEventTypeAccesses(List<EventTypeAccess> eventTypeAccesses) {
		this.eventTypeAccesses = eventTypeAccesses;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}