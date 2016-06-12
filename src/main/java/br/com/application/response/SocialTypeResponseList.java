package br.com.application.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import br.com.application.entity.SocialType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SocialTypeResponseList", propOrder = {
        "socialTypes",
        "message"
}, namespace = "http://invviteme.com/domain")
public class SocialTypeResponseList {

	private List<SocialType> socialTypes;
	private Message message;

	public List<SocialType> getSocialTypes() {
		return socialTypes;
	}

	public void setSocialTypes(List<SocialType> socialTypes) {
		this.socialTypes = socialTypes;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}