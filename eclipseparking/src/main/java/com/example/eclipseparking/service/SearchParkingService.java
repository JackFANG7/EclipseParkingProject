package com.example.eclipseparking.service;

import com.example.eclipseparking.model.ParkingMeters;
import com.example.eclipseparking.model.ParkingSigns;
import com.example.eclipseparking.model.ParkingSpot;
import com.example.eclipseparking.model.PublicParking;
import com.example.eclipseparking.repository.LocationRepository;
import com.example.eclipseparking.repository.SearchParkingMeters;
import com.example.eclipseparking.repository.SearchParkingSigns;
import com.example.eclipseparking.repository.SearchParkingStructure;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchParkingService {
    private final LocationRepository locationRepository;
    private final SearchParkingMeters searchParkingMeters;
    private final SearchParkingSigns searchParkingSigns;
    private final SearchParkingStructure searchParkingStructure;

    public SearchParkingService(LocationRepository locationRepository, SearchParkingMeters searchParkingMeters, SearchParkingSigns searchParkingSigns, SearchParkingStructure searchParkingStructure) {
        this.locationRepository = locationRepository;
        this.searchParkingMeters = searchParkingMeters;
        this.searchParkingSigns = searchParkingSigns;
        this.searchParkingStructure = searchParkingStructure;
    }
    public List<ParkingMeters> searchParkingMeters(LocalDate parkingDate, LocalDateTime parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        //connect with prediction model
        //save predicted data to elastic search and find by location
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId());
        }
        List<ParkingMeters> parkingMeters=searchParkingMeters.findByIdIn(ids);
        return parkingMeters;
    }
    public List<PublicParking> searchPublicParkings(LocalDate parkingDate, LocalDateTime parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        //connect with prediction model
        //save predicted data to elastic search and find by location
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId().intValue());
        }
        List<PublicParking> publicParkings=searchParkingStructure.findAllByIdIn(ids);
        return publicParkings;
    }
    public List<ParkingSigns> searchParkingSigns(LocalDate parkingDate, LocalDateTime parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        //connect with prediction model
        //save predicted data to elastic search and find by location
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId().intValue());
        }
        List<ParkingSigns> parkingSigns=searchParkingSigns.findAllByIdIn(ids);
        return parkingSigns;
    }
    public List<Integer> search(LocalDate parkingDate, LocalDateTime parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        //connect with prediction model
        //save predicted data to elastic search and find by location
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId());
        }
        return ids;
    }


}
