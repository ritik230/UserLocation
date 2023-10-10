package com.example.User_Location.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLocation {
    @Id
    private String id;
    private String name;
    private Double latitude;
    private Double longitude;
    public UserLocation() {}

    public UserLocation(String id,String name, double latitude, double longitude) {
         this.id=id;
        this.name= name;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
