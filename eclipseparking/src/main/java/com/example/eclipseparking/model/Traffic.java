package com.example.eclipseparking.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "loc")
public class Traffic {
    @GeoPointField
    private GeoPoint geoPoint;

}
