package br.com.application.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.application.converter.LocalDateTimeConverterXsd;

@Entity
@Table(name = "guest_event")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestEvent", propOrder = {
        "id",
        "event",
        "user",
        "attendanceConfirmed",
        "timeSentToken",
        "token",
        "dateAttendanceConfirmed"
}, namespace = "http://invviteme.com/domain")
public class GuestEvent {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    @Column(name = "attendance_confirmed")
    private Boolean attendanceConfirmed;

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(LocalDateTimeConverterXsd.class)
    @XmlSchemaType(name = "dateTime")
    @Column(name = "time_sent_token")
    private LocalDateTime timeSentToken;

    @Column(name = "token")
    private String token;
    
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(LocalDateTimeConverterXsd.class)
    @XmlSchemaType(name = "dateTime")
    @Column(name = "date_attendance_confirmed")
    private LocalDateTime dateAttendanceConfirmed;

    /**
	 * Default Constructor only use JacksonMapper
	 */
	@Deprecated
    public GuestEvent(){}
    
    public GuestEvent(Event event, Users user, long daysBeforeEvent) {
		this.event = event;
		this.user = user;
		LocalDateTime eventInitHour = event.getEventInitHour();
		this.timeSentToken = LocalDateTime.of(eventInitHour.getYear(), eventInitHour.getMonth(),
		eventInitHour.getDayOfMonth(), eventInitHour.getHour(), eventInitHour.getMinute()).minusDays(daysBeforeEvent);
		this.token = generateToken(event, user);
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    public Event getEvent() {
        return event;
    }

    public Users getUser() {
        return user;
    }

    public Boolean getAttendanceConfirmed() {
        return attendanceConfirmed;
    }

    public LocalDateTime getTimeSentToken() {
        return timeSentToken;
    }
    
    //TODO Gerar algoritmo de Token combinando dados de user e event
    private String generateToken(Event event, Users user){
    	return "";
    }
    
    public String getToken() {
        return token;
    }

    public void confirmAttendance(){
    	this.dateAttendanceConfirmed = LocalDateTime.now();
    	this.attendanceConfirmed = Boolean.TRUE;
    }
    
    public LocalDateTime getDateAttendanceConfirmed() {
		return dateAttendanceConfirmed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((attendanceConfirmed == null) ? 0 : attendanceConfirmed
						.hashCode());
		result = prime
				* result
				+ ((dateAttendanceConfirmed == null) ? 0
						: dateAttendanceConfirmed.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((timeSentToken == null) ? 0 : timeSentToken.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (dateAttendanceConfirmed == null) {
			if (other.dateAttendanceConfirmed != null)
				return false;
		} else if (!dateAttendanceConfirmed
				.equals(other.dateAttendanceConfirmed))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuestEvent [id=" + id + ", event=" + event + ", user=" + user
				+ ", attendanceConfirmed=" + attendanceConfirmed
				+ ", timeSentToken=" + timeSentToken + ", token=" + token
				+ ", dateAttendanceConfirmed=" + dateAttendanceConfirmed + "]";
	}
}
