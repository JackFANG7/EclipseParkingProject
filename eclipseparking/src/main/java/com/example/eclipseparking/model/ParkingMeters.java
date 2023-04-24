package com.example.eclipseparking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="parking_meters")
public class ParkingMeters implements Serializable {
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
    @Column(name="MAX_TIME")
    private String maxTime;
    @Column(name="HOURS_OF_OPERATION")
    private String hoursOfOperation;
    @Column(name="TYPE_OF_METER")
    private String typeOfMeter;
    private Double recommendationIndex;
    @Column(name="parkingNumber")
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public ParkingMeters setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public Double getRecommendationIndex() {
        return recommendationIndex;
    }

    public ParkingMeters setRecommendationIndex(Double recommendationIndex) {
        this.recommendationIndex = recommendationIndex;
        return this;
    }

    public int getId() {
        return id;
    }

    public ParkingMeters setId(int id) {
        this.id = id;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public ParkingMeters setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public ParkingMeters setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public int getSpaces() {
        return spaces;
    }

    public ParkingMeters setSpaces(int spaces) {
        this.spaces = spaces;
        return this;
    }

    public String getDaysOfOperation() {
        return daysOfOperation;
    }

    public ParkingMeters setDaysOfOperation(String daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
        return this;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public ParkingMeters setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
        return this;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public ParkingMeters setMaxTime(String maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public ParkingMeters setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
        return this;
    }

    public String getTypeOfMeter() {
        return typeOfMeter;
    }

    public ParkingMeters setTypeOfMeter(String typeOfMeter) {
        this.typeOfMeter = typeOfMeter;
        return this;
    }
}
