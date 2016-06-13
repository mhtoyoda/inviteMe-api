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

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.application.response.Message;

@Entity
@Table(name = "socialtype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SocialType", propOrder = {
        "id",
        "name",
        "message"
}, namespace = "http://invviteme.com/domain")
public class SocialType {
	
	@Id
    @GeneratedValue
    @JsonIgnore
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Transient
    private Message message;
	
	/**
	 * Default Constructor only use JacksonMapper
	 */
	public SocialType(){}
	
	public SocialType(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SocialType other = (SocialType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "socialType [id=" + id + ", name=" + name + "]";
	}
	
}
