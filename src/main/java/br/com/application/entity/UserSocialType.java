package br.com.application.entity;

import java.util.Date;

public class UserSocialType {
	private Integer id;
	private Integer id_user;
	private Integer id_social_type;
	private Integer status;
	private Date dateUpdated;

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

	public Integer getId_social_type() {
		return id_social_type;
	}

	public void setId_social_type(Integer id_social_type) {
		this.id_social_type = id_social_type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_social_type == null) ? 0 : id_social_type.hashCode());
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		UserSocialType other = (UserSocialType) obj;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_social_type == null) {
			if (other.id_social_type != null)
				return false;
		} else if (!id_social_type.equals(other.id_social_type))
			return false;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSocialType [id=" + id + ", id_user=" + id_user
				+ ", id_social_type=" + id_social_type + ", status=" + status
				+ ", dateUpdated=" + dateUpdated + "]";
	}

}
