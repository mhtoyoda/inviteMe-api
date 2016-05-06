package br.com.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {
	
	@Id
    @GeneratedValue
	private Integer id;
	
    @Column(name = "id_owner")
	private Integer idOwner;
    
    @Column(name = "id_eventtype_access")
	private Integer idEventTypeAccess;
    
    @Column(name = "id_eventtype")
	private Integer idEventType;
    
    @Column(name = "title")
	private String title;
    
    @Column(name = "description")
	private String description;
    
    @Column(name = "eventdate")
	private Date eventDate;
    
    @Column(name = "event_init_hour")
	private Date eventInitHour;
    
    @Column(name = "event_end_hour")
	private Date eventEndHour;
    
    @Column(name = "limit_guests")
	private Integer limitGuests;
    
    @Column(name = "id_address_event")
	private Integer idAdressEvent;
    
    @Column(name = "id_statustype")
	private Integer idStatusType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Integer idOwner) {
		this.idOwner = idOwner;
	}

	public Integer getIdEventTypeAccess() {
		return idEventTypeAccess;
	}

	public void setIdEventTypeAccess(Integer idEventTypeAccess) {
		this.idEventTypeAccess = idEventTypeAccess;
	}

	public Integer getIdEventType() {
		return idEventType;
	}

	public void setIdEventType(Integer idEventType) {
		this.idEventType = idEventType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getEventInitHour() {
		return eventInitHour;
	}

	public void setEventInitHour(Date eventInitHour) {
		this.eventInitHour = eventInitHour;
	}

	public Date getEventEndHour() {
		return eventEndHour;
	}

	public void setEventEndHour(Date eventEndHour) {
		this.eventEndHour = eventEndHour;
	}

	public Integer getLimitGuests() {
		return limitGuests;
	}

	public void setLimitGuests(Integer limitGuests) {
		this.limitGuests = limitGuests;
	}

	public Integer getIdAdressEvent() {
		return idAdressEvent;
	}

	public void setIdAdressEvent(Integer idAdressEvent) {
		this.idAdressEvent = idAdressEvent;
	}

	public Integer getIdStatusType() {
		return idStatusType;
	}

	public void setIdStatusType(Integer idStatusType) {
		this.idStatusType = idStatusType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result
				+ ((eventEndHour == null) ? 0 : eventEndHour.hashCode());
		result = prime * result
				+ ((eventInitHour == null) ? 0 : eventInitHour.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idAdressEvent == null) ? 0 : idAdressEvent.hashCode());
		result = prime * result
				+ ((idEventType == null) ? 0 : idEventType.hashCode());
		result = prime
				* result
				+ ((idEventTypeAccess == null) ? 0 : idEventTypeAccess
						.hashCode());
		result = prime * result + ((idOwner == null) ? 0 : idOwner.hashCode());
		result = prime * result
				+ ((idStatusType == null) ? 0 : idStatusType.hashCode());
		result = prime * result
				+ ((limitGuests == null) ? 0 : limitGuests.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventEndHour == null) {
			if (other.eventEndHour != null)
				return false;
		} else if (!eventEndHour.equals(other.eventEndHour))
			return false;
		if (eventInitHour == null) {
			if (other.eventInitHour != null)
				return false;
		} else if (!eventInitHour.equals(other.eventInitHour))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idAdressEvent == null) {
			if (other.idAdressEvent != null)
				return false;
		} else if (!idAdressEvent.equals(other.idAdressEvent))
			return false;
		if (idEventType == null) {
			if (other.idEventType != null)
				return false;
		} else if (!idEventType.equals(other.idEventType))
			return false;
		if (idEventTypeAccess == null) {
			if (other.idEventTypeAccess != null)
				return false;
		} else if (!idEventTypeAccess.equals(other.idEventTypeAccess))
			return false;
		if (idOwner == null) {
			if (other.idOwner != null)
				return false;
		} else if (!idOwner.equals(other.idOwner))
			return false;
		if (idStatusType == null) {
			if (other.idStatusType != null)
				return false;
		} else if (!idStatusType.equals(other.idStatusType))
			return false;
		if (limitGuests == null) {
			if (other.limitGuests != null)
				return false;
		} else if (!limitGuests.equals(other.limitGuests))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
