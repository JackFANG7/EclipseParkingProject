package com.example.eclipseparking.controller;

import com.example.eclipseparking.model.ParkingMeters;
import com.example.eclipseparking.model.ParkingSigns;
import com.example.eclipseparking.model.PublicParking;
import com.example.eclipseparking.service.GenerateRecommendationIndex;
import com.example.eclipseparking.service.GeoCodingService;
import com.example.eclipseparking.service.ParkingLotService;
import com.example.eclipseparking.service.SearchParkingService;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchParkingController {
    private final SearchParkingService searchParkingService;
    private final ParkingLotService parkingLotService;
    private final GeoCodingService geoCodingService;
    private final GenerateRecommendationIndex generateRecommendationIndex;
    public SearchParkingController(SearchParkingService searchParkingService, ParkingLotService parkingLotService, GeoCodingService geoCodingService, GenerateRecommendationIndex generateRecommendationIndex) {
        this.searchParkingService = searchParkingService;
        this.parkingLotService = parkingLotService;
        this.geoCodingService = geoCodingService;
        this.generateRecommendationIndex = generateRecommendationIndex;
    }
    @GetMapping("/get/search")
    public List<Integer> search( @RequestParam(name="address") String address,
                                 @RequestParam(name = "date") String date,
                                 @RequestParam(name = "time") String time){
        GeoPoint geoPoint=geoCodingService.getLatLng(address);
        return searchParkingService.search(null,null,geoPoint.getLat(),geoPoint.getLon(),"0.2");
    }
    @GetMapping("/get/parkingMeters")
    public List<ParkingMeters> getParkingMeters(@RequestParam(name="address") String address,
                                                @RequestParam(name = "date") String date,
                                                @RequestParam(name = "time") String time){
        GeoPoint geoPoint=geoCodingService.getLatLng(address);
        return searchParkingService.searchParkingMeters(date,time,geoPoint.getLat(),geoPoint.getLon(),"0.25");
    }
    @GetMapping("/get/parkingSigns")
    public List<ParkingSigns> getParkingSigns(@RequestParam(name="address") String address,
                                              @RequestParam(name = "date") String date,
                                              @RequestParam(name = "time") String time){
        GeoPoint geoPoint=geoCodingService.getLatLng(address);
        return searchParkingService.searchParkingSigns(date,time.substring(time.length()-2,time.length()),geoPoint.getLat(),geoPoint.getLon(),"0.1");
    }
    @GetMapping("/get/parkingStructures")
    public List<PublicParking> getParkingStructures(@RequestParam(name="address") String address,
                                                    @RequestParam(name = "date") String date,
                                                    @RequestParam(name = "time") String time){
        GeoPoint geoPoint=geoCodingService.getLatLng(address);
        return searchParkingService.searchPublicParkings(date,time,geoPoint.getLat(),geoPoint.getLon(),"0.35");
    }
//    @PostMapping("/add")
//    public void add() throws IOException {
//        String csvFilePath="/Users/fangjianjun/IdeaProjects/eclipseparking/src/main/java/location.csv";
//        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
//        String lineText = null;
//        try {
//            lineReader.readLine(); // skip header line
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        while ((lineText = lineReader.readLine()) != null) {
//            String[] data = lineText.split(",");
//            String lat = data[0];
//            String lon = data[1];
//            String id = data[2];
//            GeoPoint geoPoint=new GeoPoint(Double.valueOf(lat),Double.valueOf(lon));
//            ParkingSpot parkingSpot=new ParkingSpot(Integer.valueOf(id),geoPoint);
//            parkingLotService.add(parkingSpot);
//        }
//    }
}
