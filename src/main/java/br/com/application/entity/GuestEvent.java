package br.com.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class GuestEvent {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@Column(name = "id_event")
	private Integer idEvent;
	
	@Column(name = "id_user")
	private Integer idUser;
	
	@Column(name = "attendance_confirmed")
	private Boolean attendanceConfirmed;
	
	@Column(name = "time_sent_token")
	private Date timeSentToken;
	
	@Column(name = "token")
	private String token;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Boolean getAttendanceConfirmed() {
		return attendanceConfirmed;
	}

	public void setAttendanceConfirmed(Boolean attendanceConfirmed) {
		this.attendanceConfirmed = attendanceConfirmed;
	}

	public Date getTimeSentToken() {
		return timeSentToken;
	}

	public void setTimeSentToken(Date timeSentToken) {
		this.timeSentToken = timeSentToken;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((attendanceConfirmed == null) ? 0 : attendanceConfirmed
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEvent == null) ? 0 : idEvent.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result
				+ ((timeSentToken == null) ? 0 : timeSentToken.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		GuestEvent other = (GuestEvent) obj;
		if (attendanceConfirmed == null) {
			if (other.attendanceConfirmed != null)
				return false;
		} else if (!attendanceConfirmed.equals(other.attendanceConfirmed))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEvent == null) {
			if (other.idEvent != null)
				return false;
		} else if (!idEvent.equals(other.idEvent))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (timeSentToken == null) {
			if (other.timeSentToken != null)
				return false;
		} else if (!timeSentToken.equals(other.timeSentToken))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

}
