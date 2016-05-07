package br.com.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address_Event")
public class AddressEvent {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "placename")
    private String placeName;

    @Column(name = "streetname")
    private String streetName;

    @Column(name = "number")
    private Integer number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "cityname")
    private String cityName;

    @Column(name = "longitude")
    private Long longitude;

    @Column(name = "latitude")
    private Long latitude;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
        result = prime * result + ((complement == null) ? 0 : complement.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((placeName == null) ? 0 : placeName.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AddressEvent other = (AddressEvent) obj;
        if (cityName == null) {
            if (other.cityName != null) return false;
        } else if (!cityName.equals(other.cityName)) return false;
        if (complement == null) {
            if (other.complement != null) return false;
        } else if (!complement.equals(other.complement)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (latitude == null) {
            if (other.latitude != null) return false;
        } else if (!latitude.equals(other.latitude)) return false;
        if (longitude == null) {
            if (other.longitude != null) return false;
        } else if (!longitude.equals(other.longitude)) return false;
        if (number == null) {
            if (other.number != null) return false;
        } else if (!number.equals(other.number)) return false;
        if (placeName == null) {
            if (other.placeName != null) return false;
        } else if (!placeName.equals(other.placeName)) return false;
        if (state == null) {
            if (other.state != null) return false;
        } else if (!state.equals(other.state)) return false;
        if (streetName == null) {
            if (other.streetName != null) return false;
        } else if (!streetName.equals(other.streetName)) return false;
        if (zipCode == null) {
            if (other.zipCode != null) return false;
        } else if (!zipCode.equals(other.zipCode)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "AddressEvent [id=" + id + ", placeName=" + placeName + ", streetName=" + streetName + ", number=" + number + ", complement="
                        + complement + ", zipCode=" + zipCode + ", cityName=" + cityName + ", longitude=" + longitude + ", latitude=" + latitude
                        + ", state=" + state + "]";
    }

}
