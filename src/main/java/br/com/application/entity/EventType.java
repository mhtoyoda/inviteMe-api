package br.com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.application.response.Message;

@Entity
@Table(name = "eventtype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventType", propOrder = {
        "id",
        "category",
        "statusType",
        "message"
}, namespace = "http://invviteme.com/domain")
public class EventType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    @Column(name = "category")
    private String category;
    
	@ManyToOne
	@JoinColumn(name = "id_statustype")
	private StatusType statusType;

	@Transient
    private Message message;
	
	/**
	 * Default Constructor only use JacksonMapper
	 */
	public EventType() {}

	public EventType(String category, StatusType statusType) {
		this.category = category;
		this.statusType = statusType;
	}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public StatusType getStatusType() {
        return statusType;
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
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((statusType == null) ? 0 : statusType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EventType other = (EventType) obj;
        if (category == null) {
            if (other.category != null) return false;
        } else if (!category.equals(other.category)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (statusType == null) {
            if (other.statusType != null) return false;
        } else if (!statusType.equals(other.statusType)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "EventType [id=" + id + ", category=" + category + ", statusType=" + statusType + "]";
    }

}
