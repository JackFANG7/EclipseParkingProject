package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.ParkingMeters;
import com.example.eclipseparking.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchParkingMeters extends JpaRepository<ParkingMeters,Integer> {
    List<ParkingMeters> findByIdIn(List<Integer> ids);
}
