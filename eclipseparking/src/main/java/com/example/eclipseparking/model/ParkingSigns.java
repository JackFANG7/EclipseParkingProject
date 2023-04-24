package com.example.eclipseparking.model;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="parking_signs")
public class ParkingSigns implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    private Integer id;
    private Double lat;
    private Double lon;
    private String sign;
    private Double recommendationIndex;
    @Column(name="parkingNumber")
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public ParkingSigns setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public Double getRecommendationIndex() {
        return recommendationIndex;
    }

    public ParkingSigns setRecommendationIndex(Double recommendationIndex) {
        this.recommendationIndex = recommendationIndex;
        return this;
    }

    public int getId() {
        return id;
    }

    public ParkingSigns setId(int id) {
        this.id = id;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public ParkingSigns setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public ParkingSigns setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public ParkingSigns setSign(String sign) {
        this.sign = sign;
        return this;
    }
}
