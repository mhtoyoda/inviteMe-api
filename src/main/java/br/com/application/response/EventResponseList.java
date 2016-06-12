package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.Event;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventResponseList", propOrder = {
        "events",
        "message"
}, namespace = "http://invviteme.com/domain")
public class EventResponseList {

	private List<Event> events;
	private Message message;

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}