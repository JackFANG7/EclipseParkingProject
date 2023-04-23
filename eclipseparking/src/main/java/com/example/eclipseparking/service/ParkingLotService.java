package com.example.eclipseparking.service;

import com.example.eclipseparking.model.ParkingSpot;
import com.example.eclipseparking.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotService {
    private final LocationRepository locationRepository;


    public ParkingLotService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(ParkingSpot parkingSpot) {
        locationRepository.save(parkingSpot);
    }
}
