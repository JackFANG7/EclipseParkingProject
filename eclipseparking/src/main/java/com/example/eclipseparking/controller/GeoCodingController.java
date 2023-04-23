package com.example.eclipseparking.controller;

import com.example.eclipseparking.service.GeoCodingService;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoCodingController {
    private final GeoCodingService geoCodingService;

    public GeoCodingController(GeoCodingService geoCodingService) {
        this.geoCodingService = geoCodingService;
    }
    @GetMapping("/address")
    public GeoPoint decodeAddress(@RequestParam String address){
        return geoCodingService.getLatLng(address);
    }
}
