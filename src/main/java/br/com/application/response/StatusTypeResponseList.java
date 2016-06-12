package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.StatusType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusTypeResponseList", propOrder = {
        "statusTypes",
        "message"
}, namespace = "http://invviteme.com/domain")
public class StatusTypeResponseList {

	private List<StatusType> statusTypes;
	private Message message;

	public List<StatusType> getStatusTypes() {
		return statusTypes;
	}

	public void setStatusTypes(List<StatusType> statusTypes) {
		this.statusTypes = statusTypes;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}