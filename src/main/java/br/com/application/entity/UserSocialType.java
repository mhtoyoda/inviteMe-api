package br.com.application.entity;

import java.time.LocalDate;
import java.util.Date;

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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.application.converter.LocalDateConverterXsd;
import br.com.application.response.Message;


@Entity
@Table(name = "user_socialtype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserSocialType", propOrder = {
        "userSocialTypeId",
        "user",
        "socialType",
        "status",        
        "dateUpdated",
        "message"
}, namespace = "http://invviteme.com/domain")
public class UserSocialType  extends ResourceSupport {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonIgnore
	private Integer userSocialTypeId;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
	private Users user;
    
    @ManyToOne
    @JoinColumn(name = "id_socialtype")
	private SocialType socialType;
	
	@Column(name = "status")
	private Boolean status;
	
    @XmlJavaTypeAdapter(LocalDateConverterXsd.class)
    @XmlSchemaType(name = "date")
	@Column(name = "date_updated")
	private LocalDate dateUpdated;
	
    @Transient
    private Message message;
    
	/**
	 * Default Constructor only use JacksonMapper
	 */
	public UserSocialType(){}	
	
    public UserSocialType(Users user, SocialType socialType, Date dateUpdated) {		
		this.user = user;
		this.socialType = socialType;
		this.status = Boolean.TRUE;
		this.dateUpdated = LocalDate.now();
	}

    public Integer getUserSocialTypeId() {
		return userSocialTypeId;
	}

	public void setUserSocialTypeId(Integer userSocialTypeId) {
		this.userSocialTypeId = userSocialTypeId;
	}

	public Users getUser() {
		return user;
	}

	public SocialType getSocialType() {
		return socialType;
	}

	public void alterStatus(Boolean status) {
		this.status = status;
		this.dateUpdated = LocalDate.now();
	}
	
	public Boolean getStatus() {
		return status;
	}

	public LocalDate getDateUpdated() {
		return dateUpdated;
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
        result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
        result = prime * result + ((userSocialTypeId == null) ? 0 : userSocialTypeId.hashCode());
        result = prime * result + ((socialType == null) ? 0 : socialType.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        UserSocialType other = (UserSocialType) obj;
        if (dateUpdated == null) {
            if (other.dateUpdated != null) return false;
        } else if (!dateUpdated.equals(other.dateUpdated)) return false;
        if (userSocialTypeId == null) {
            if (other.userSocialTypeId != null) return false;
        } else if (!userSocialTypeId.equals(other.userSocialTypeId)) return false;
        if (socialType == null) {
            if (other.socialType != null) return false;
        } else if (!socialType.equals(other.socialType)) return false;
        if (status == null) {
            if (other.status != null) return false;
        } else if (!status.equals(other.status)) return false;
        if (user == null) {
            if (other.user != null) return false;
        } else if (!user.equals(other.user)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserSocialType [userSocialTypeId=" + userSocialTypeId + ", user=" + user + ", socialType=" + socialType + ", status=" + status + ", dateUpdated=" + dateUpdated
                        + "]";
    }
}
