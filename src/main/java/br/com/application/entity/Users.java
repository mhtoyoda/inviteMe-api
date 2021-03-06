package br.com.application.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Users", propOrder = {
        "userId",
        "name",
        "lastName",
        "phoneNumber",
        "email",
        "gender",
        "password",
        "statusType",
        "dateUpdated",
        "birthday",
        "admin",
        "message"
}, namespace = "http://invviteme.com/domain")
public class Users extends ResourceSupport implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3003719924454999905L;

	@Id
    @GeneratedValue
    @Column(name = "id")
	@JsonIgnore
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private char gender;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_statustype")
    private StatusType statusType;
  
    @XmlJavaTypeAdapter(LocalDateConverterXsd.class)
    @XmlSchemaType(name = "date")
    @Column(name = "date_updated")
    private LocalDate dateUpdated;
    
    @XmlJavaTypeAdapter(LocalDateConverterXsd.class)
    @XmlSchemaType(name = "date")
    @Column(name = "date_birthday")
    private LocalDate birthday;
	
    @Column(name = "admin")
    private boolean admin;
    
    @Transient
    private Message message;
    
    /**
     * Default Constructor only use JacksonMapper
     */    
    public Users(){}    
	public Users(String name, String lastName, LocalDate birthday, String phoneNumber, String email, String password, char gender, StatusType statusType) {		
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;		
		this.gender = gender;
		this.statusType = statusType;
		this.dateUpdated = LocalDate.now();
		this.admin = Boolean.FALSE;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public char getGender() {
		return gender;
	}
	
	public void alterPassword(String password) {
		this.password = password;
		this.dateUpdated = LocalDate.now();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void alterStatusType(StatusType statusType){
		this.statusType = statusType;
		this.dateUpdated = LocalDate.now();
	}
	
	public StatusType getStatusType() {
		return statusType;
	}

	public LocalDate getDateUpdated() {
		return dateUpdated;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	public boolean isAdmin() {
		return admin;
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
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result
				+ ((statusType == null) ? 0 : statusType.hashCode());
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
		Users other = (Users) obj;
		if (admin != other.admin)
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (statusType == null) {
			if (other.statusType != null)
				return false;
		} else if (!statusType.equals(other.statusType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", gender=" + gender + ", password=" + password
				+ ", statusType=" + statusType + ", dateUpdated=" + dateUpdated
				+ ", birthday=" + birthday + ", admin=" + admin + "]";
	}
}
