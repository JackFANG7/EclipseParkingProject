package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.ParkingSpot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomLocationRepository {
    List<ParkingSpot> searchByDistance(double lat, double lon, String distance);
}
