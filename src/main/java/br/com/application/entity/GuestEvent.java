package br.com.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
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

    @Column(name = "time_sent_token")
    private Date timeSentToken;

    @Column(name = "token")
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Boolean getAttendanceConfirmed() {
        return attendanceConfirmed;
    }

    public void setAttendanceConfirmed(Boolean attendanceConfirmed) {
        this.attendanceConfirmed = attendanceConfirmed;
    }

    public Date getTimeSentToken() {
        return timeSentToken;
    }

    public void setTimeSentToken(Date timeSentToken) {
        this.timeSentToken = timeSentToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attendanceConfirmed == null) ? 0 : attendanceConfirmed.hashCode());
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((timeSentToken == null) ? 0 : timeSentToken.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        GuestEvent other = (GuestEvent) obj;
        if (attendanceConfirmed == null) {
            if (other.attendanceConfirmed != null) return false;
        } else if (!attendanceConfirmed.equals(other.attendanceConfirmed)) return false;
        if (event == null) {
            if (other.event != null) return false;
        } else if (!event.equals(other.event)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (timeSentToken == null) {
            if (other.timeSentToken != null) return false;
        } else if (!timeSentToken.equals(other.timeSentToken)) return false;
        if (token == null) {
            if (other.token != null) return false;
        } else if (!token.equals(other.token)) return false;
        if (user == null) {
            if (other.user != null) return false;
        } else if (!user.equals(other.user)) return false;
        return true;
    }
}
