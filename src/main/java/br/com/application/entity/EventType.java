package br.com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EventType")
public class EventType {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "id_statustype")
	private Integer idStatusType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idStatusType == null) ? 0 : idStatusType.hashCode());
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
		EventType other = (EventType) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idStatusType == null) {
			if (other.idStatusType != null)
				return false;
		} else if (!idStatusType.equals(other.idStatusType))
			return false;
		return true;
	}

}
