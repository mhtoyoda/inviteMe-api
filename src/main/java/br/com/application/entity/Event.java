package br.com.application.entity;

import java.util.Date;

public class Event {
	private Integer id;
	private Integer id_user;
	private Integer id_type_access;
	private Integer id_type_event;
	private String title;
	private String description;
	private Date dateEvent;
	private Integer limitGuests;
	private Integer id_adress_event;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_type_access() {
		return id_type_access;
	}

	public void setId_type_access(Integer id_type_access) {
		this.id_type_access = id_type_access;
	}

	public Integer getId_type_event() {
		return id_type_event;
	}

	public void setId_type_event(Integer id_type_event) {
		this.id_type_event = id_type_event;
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

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public Integer getLimitGuests() {
		return limitGuests;
	}

	public void setLimitGuests(Integer limitGuests) {
		this.limitGuests = limitGuests;
	}

	public Integer getId_adress_event() {
		return id_adress_event;
	}

	public void setId_adress_event(Integer id_adress_event) {
		this.id_adress_event = id_adress_event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateEvent == null) ? 0 : dateEvent.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_adress_event == null) ? 0 : id_adress_event.hashCode());
		result = prime * result
				+ ((id_type_access == null) ? 0 : id_type_access.hashCode());
		result = prime * result
				+ ((id_type_event == null) ? 0 : id_type_event.hashCode());
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
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
		if (dateEvent == null) {
			if (other.dateEvent != null)
				return false;
		} else if (!dateEvent.equals(other.dateEvent))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_adress_event == null) {
			if (other.id_adress_event != null)
				return false;
		} else if (!id_adress_event.equals(other.id_adress_event))
			return false;
		if (id_type_access == null) {
			if (other.id_type_access != null)
				return false;
		} else if (!id_type_access.equals(other.id_type_access))
			return false;
		if (id_type_event == null) {
			if (other.id_type_event != null)
				return false;
		} else if (!id_type_event.equals(other.id_type_event))
			return false;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", id_user=" + id_user + ", id_type_access="
				+ id_type_access + ", id_type_event=" + id_type_event
				+ ", title=" + title + ", description=" + description
				+ ", dateEvent=" + dateEvent + ", limitGuests=" + limitGuests
				+ ", id_adress_event=" + id_adress_event + "]";
	}

}
