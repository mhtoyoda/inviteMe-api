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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.application.converter.LocalDateConverterXsd;


@Entity
@Table(name = "user_socialtype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserSocialType", propOrder = {
        "id",
        "user",
        "socialType",
        "status",        
        "dateUpdated"
}, namespace = "http://invviteme.com/domain")
public class UserSocialType {
    
    @Id
    @GeneratedValue
	private Integer id;
    
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
	
	/**
	 * Default Constructor only use JacksonMapper
	 */
	@Deprecated
	public UserSocialType(){}	
	
    public UserSocialType(Users user, SocialType socialType, Date dateUpdated) {		
		this.user = user;
		this.socialType = socialType;
		this.status = Boolean.TRUE;
		this.dateUpdated = LocalDate.now();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
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
        return "UserSocialType [id=" + id + ", user=" + user + ", socialType=" + socialType + ", status=" + status + ", dateUpdated=" + dateUpdated
                        + "]";
    }
}
