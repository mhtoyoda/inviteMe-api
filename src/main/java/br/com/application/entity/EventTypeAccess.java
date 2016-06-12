package br.com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.springframework.hateoas.ResourceSupport;

import br.com.application.response.Message;

@Entity
@Table(name = "eventtype_access")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTypeAccess", propOrder = {
        "eventTypeAccessId",
        "typeAccess",
        "message"
}, namespace = "http://invviteme.com/domain")
public class EventTypeAccess extends ResourceSupport {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	private Integer eventTypeAccessId;
	
	@Column(name = "type_access")
	private String typeAccess;
	
	@Transient
    private Message message;
	
	/**
	 * Default Constructor only use JacksonMapper
	 */
	public EventTypeAccess() {}
	
	public EventTypeAccess(String typeAccess) {
		this.typeAccess = typeAccess;
	}

	public Integer getEventTypeAccessId() {
		return eventTypeAccessId;
	}

	public void setEventTypeAccessId(Integer eventTypeAccessId) {
		this.eventTypeAccessId = eventTypeAccessId;
	}

	public String getTypeAccess() {
		return typeAccess;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventTypeAccessId == null) ? 0 : eventTypeAccessId.hashCode());
		result = prime * result
				+ ((typeAccess == null) ? 0 : typeAccess.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventTypeAccess other = (EventTypeAccess) obj;
		if (eventTypeAccessId == null) {
			if (other.eventTypeAccessId != null)
				return false;
		} else if (!eventTypeAccessId.equals(other.eventTypeAccessId))
			return false;
		if (typeAccess == null) {
			if (other.typeAccess != null)
				return false;
		} else if (!typeAccess.equals(other.typeAccess))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "EventTypeAccess [eventTypeAccessId=" + eventTypeAccessId + ", typeAccess=" + typeAccess + "]";
    }
}