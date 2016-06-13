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

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.application.response.Message;

@Entity
@Table(name = "user_guest_unified")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserGuestUnified", propOrder = {
        "userGuestUnifiedId",
        "user",
        "event",
        "amount",
        "message"
}, namespace = "http://invviteme.com/domain")
public class UserGuestUnified extends ResourceSupport {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonIgnore
    private Integer userGuestUnifiedId;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private Event event;

    @Column(name = "amount")
    private Integer amount;

    @Transient
    private Message message;
    
    /**
	 * Default Constructor only use JacksonMapper
	 */
    public UserGuestUnified(){}
	
    public UserGuestUnified(Users user, Event event, Integer amount) {
		this.user = user;
		this.event = event;
		this.amount = amount;
	}
    
    public Integer getUserGuestUnifiedId() {
		return userGuestUnifiedId;
	}

	public void setUserGuestUnifiedId(Integer userGuestUnifiedId) {
		this.userGuestUnifiedId = userGuestUnifiedId;
	}

	public Users getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getAmount() {
        return amount;
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
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + ((userGuestUnifiedId == null) ? 0 : userGuestUnifiedId.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        UserGuestUnified other = (UserGuestUnified) obj;
        if (amount == null) {
            if (other.amount != null) return false;
        } else if (!amount.equals(other.amount)) return false;
        if (event == null) {
            if (other.event != null) return false;
        } else if (!event.equals(other.event)) return false;
        if (userGuestUnifiedId == null) {
            if (other.userGuestUnifiedId != null) return false;
        } else if (!userGuestUnifiedId.equals(other.userGuestUnifiedId)) return false;
        if (user == null) {
            if (other.user != null) return false;
        } else if (!user.equals(other.user)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserGuestUnified [userGuestUnifiedId=" + userGuestUnifiedId + ", user=" + user + ", event=" + event + ", amount=" + amount + "]";
    }
}
