package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.ParkingSigns;
import com.example.eclipseparking.model.ParkingSpot;
import com.example.eclipseparking.model.PublicParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchParkingSigns extends JpaRepository<ParkingSigns,Integer> {
    List<ParkingSigns> findAllByIdIn(List<Integer> ids);
}
