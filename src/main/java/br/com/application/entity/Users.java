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

@Entity
@Table(name = "users")
public class Users implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3003719924454999905L;

	@Id
    @GeneratedValue
    private Integer id;

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

    @Column(name = "date_updated")
    private LocalDate dateUpdated;
    
    @Column(name = "date_birthday")
    private LocalDate birthday;
	
    @Column(name = "admin")
    private boolean admin;
    
    /**
     * Default Constructor only use JacksonMapper
     */
    @Deprecated
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

	public void setId(Integer id) {
		this.id = id;
	}
	
    public Integer getId() {
		return id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Users [id=" + id + ", name=" + name + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", gender=" + gender + ", password=" + password
				+ ", statusType=" + statusType + ", dateUpdated=" + dateUpdated
				+ ", birthday=" + birthday + ", admin=" + admin + "]";
	}
}
