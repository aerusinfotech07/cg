package com.usermanagement.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "geo")
public class Geo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat", nullable = false)
    private String lat;

    @Column(name = "lng", nullable = false)
    private String lng;

    public Geo() {
    }

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLat() { return lat; }
    public void setLat(String lat) { this.lat = lat; }
    public String getLng() { return lng; }
    public void setLng(String lng) { this.lng = lng; }
}
