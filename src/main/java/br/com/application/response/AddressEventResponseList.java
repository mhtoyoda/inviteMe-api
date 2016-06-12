package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.AddressEvent;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressEventResponseList", propOrder = {
        "addressEvents",
        "message"
}, namespace = "http://invviteme.com/domain")
public class AddressEventResponseList {

	private List<AddressEvent> addressEvents;
	private Message message;

	public List<AddressEvent> getAddressEvents() {
		return addressEvents;
	}

	public void setAddressEvents(List<AddressEvent> addressEvents) {
		this.addressEvents = addressEvents;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}