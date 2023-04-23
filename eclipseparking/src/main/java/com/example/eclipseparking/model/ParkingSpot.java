package com.example.eclipseparking.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.persistence.Id;
import java.io.Serializable;

@Document(indexName = "location")
public class ParkingSpot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Field(type = FieldType.Integer)
    private Integer id;
    @GeoPointField
    private GeoPoint geoPoint;
    private double distance;
    public ParkingSpot(Integer id, GeoPoint geoPoint) {
        this.id = id;
        this.geoPoint = geoPoint;
    }

    public Integer getId() {
        return id;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }
    public Double getDistance(){
        return distance;
    }
    public void setDistance(double distance){
        this.distance=distance;
    }
}
