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
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users owner;

    @ManyToOne
    @JoinColumn(name = "id_eventtype_access")
    private EventTypeAccess eventTypeAccess;

    @ManyToOne
    @JoinColumn(name = "id_eventtype")
    private EventType eventType;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "eventdate")
    private Date eventDate;

    @Column(name = "event_init_hour")
    private Date eventInitHour;

    @Column(name = "event_end_hour")
    private Date eventEndHour;

    @Column(name = "limit_guests")
    private Integer limitGuests;

    @ManyToOne
    @JoinColumn(name = "id_address_event")
    private AddressEvent addressEvent;

    @ManyToOne
    @JoinColumn(name = "id_statustype")
    private StatusType statusType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public EventTypeAccess getEventTypeAccess() {
        return eventTypeAccess;
    }

    public void setEventTypeAccess(EventTypeAccess eventTypeAccess) {
        this.eventTypeAccess = eventTypeAccess;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventInitHour() {
        return eventInitHour;
    }

    public void setEventInitHour(Date eventInitHour) {
        this.eventInitHour = eventInitHour;
    }

    public Date getEventEndHour() {
        return eventEndHour;
    }

    public void setEventEndHour(Date eventEndHour) {
        this.eventEndHour = eventEndHour;
    }

    public Integer getLimitGuests() {
        return limitGuests;
    }

    public void setLimitGuests(Integer limitGuests) {
        this.limitGuests = limitGuests;
    }

    public AddressEvent getAddressEvent() {
        return addressEvent;
    }

    public void setAddressEvent(AddressEvent addressEvent) {
        this.addressEvent = addressEvent;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressEvent == null) ? 0 : addressEvent.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
        result = prime * result + ((eventEndHour == null) ? 0 : eventEndHour.hashCode());
        result = prime * result + ((eventInitHour == null) ? 0 : eventInitHour.hashCode());
        result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
        result = prime * result + ((eventTypeAccess == null) ? 0 : eventTypeAccess.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((limitGuests == null) ? 0 : limitGuests.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((statusType == null) ? 0 : statusType.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Event other = (Event) obj;
        if (addressEvent == null) {
            if (other.addressEvent != null) return false;
        } else if (!addressEvent.equals(other.addressEvent)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (eventDate == null) {
            if (other.eventDate != null) return false;
        } else if (!eventDate.equals(other.eventDate)) return false;
        if (eventEndHour == null) {
            if (other.eventEndHour != null) return false;
        } else if (!eventEndHour.equals(other.eventEndHour)) return false;
        if (eventInitHour == null) {
            if (other.eventInitHour != null) return false;
        } else if (!eventInitHour.equals(other.eventInitHour)) return false;
        if (eventType == null) {
            if (other.eventType != null) return false;
        } else if (!eventType.equals(other.eventType)) return false;
        if (eventTypeAccess == null) {
            if (other.eventTypeAccess != null) return false;
        } else if (!eventTypeAccess.equals(other.eventTypeAccess)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (limitGuests == null) {
            if (other.limitGuests != null) return false;
        } else if (!limitGuests.equals(other.limitGuests)) return false;
        if (owner == null) {
            if (other.owner != null) return false;
        } else if (!owner.equals(other.owner)) return false;
        if (statusType == null) {
            if (other.statusType != null) return false;
        } else if (!statusType.equals(other.statusType)) return false;
        if (title == null) {
            if (other.title != null) return false;
        } else if (!title.equals(other.title)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", owner=" + owner + ", eventTypeAccess=" + eventTypeAccess + ", eventType=" + eventType + ", title=" + title
                        + ", description=" + description + ", eventDate=" + eventDate + ", eventInitHour=" + eventInitHour + ", eventEndHour="
                        + eventEndHour + ", limitGuests=" + limitGuests + ", addressEvent=" + addressEvent + ", statusType=" + statusType + "]";
    }
}
