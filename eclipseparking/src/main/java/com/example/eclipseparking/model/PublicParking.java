package com.example.eclipseparking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="parking_structure")
public class PublicParking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private Double lat;
    private Double lon;
    private Integer spaces;
    @Column(name="DAYS_OF_OPERATION")
    private String daysOfOperation;
    @Column(name = "HOURLY_RATE")
    private String hourlyRate;
    @Column(name="EV_CHARGING")
    private String evCharging;
    private Double recommendationIndex;
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public PublicParking setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public Double getRecommendationIndex() {
        return recommendationIndex;
    }

    public PublicParking setRecommendationIndex(Double recommendationIndex) {
        this.recommendationIndex = recommendationIndex;
        return this;
    }

    public int getId() {
        return id;
    }

    public PublicParking setId(int id) {
        this.id = id;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public PublicParking setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public PublicParking setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public int getSpaces() {
        return spaces;
    }

    public PublicParking setSpaces(int spaces) {
        this.spaces = spaces;
        return this;
    }

    public String getDaysOfOperation() {
        return daysOfOperation;
    }

    public PublicParking setDaysOfOperation(String daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
        return this;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public PublicParking setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
        return this;
    }

    public String getEvCharging() {
        return evCharging;
    }

    public PublicParking setEvCharging(String evCharging) {
        this.evCharging = evCharging;
        return this;
    }
}
