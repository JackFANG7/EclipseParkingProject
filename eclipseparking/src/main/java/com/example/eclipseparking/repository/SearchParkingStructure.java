package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.ParkingSpot;
import com.example.eclipseparking.model.PublicParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchParkingStructure extends JpaRepository<PublicParking,Integer> {
    List<PublicParking> findAllByIdIn(List<Integer> ids);
}
