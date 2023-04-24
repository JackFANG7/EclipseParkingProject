package com.example.eclipseparking.service;

import com.example.eclipseparking.model.ParkingMeters;
import com.example.eclipseparking.model.ParkingSigns;
import com.example.eclipseparking.model.ParkingSpot;
import com.example.eclipseparking.model.PublicParking;
import com.example.eclipseparking.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SearchParkingService {
    private final LocationRepository locationRepository;
    private final SearchParkingMeters searchParkingMeters;
    private final SearchParkingSigns searchParkingSigns;
    private final SearchParkingStructure searchParkingStructure;
    private final PredictionRepository predictionRepository;

    public SearchParkingService(LocationRepository locationRepository, SearchParkingMeters searchParkingMeters, SearchParkingSigns searchParkingSigns, SearchParkingStructure searchParkingStructure, PredictionRepository predictionRepository) {
        this.locationRepository = locationRepository;
        this.searchParkingMeters = searchParkingMeters;
        this.searchParkingSigns = searchParkingSigns;
        this.searchParkingStructure = searchParkingStructure;
        this.predictionRepository = predictionRepository;
    }
    public List<ParkingMeters> searchParkingMeters(String parkingDate, String parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        Map<Integer,Double> map=new HashMap<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId());
            map.put(parkingSpot.getId(),parkingSpot.getDistance());
        }
        List<ParkingMeters> parkingMeters=searchParkingMeters.findByIdIn(ids);
        String[] splitString=parkingTime.split(":");
        if(splitString[0].startsWith("0")){
            splitString[0]=splitString[0].substring(1,2);
        }
        int index=Integer.parseInt(splitString[0])*2+(Integer.parseInt(splitString[1])==30 ? 1 : 0);
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;
        for(ParkingMeters parkingMeter: parkingMeters){
            Double[] timeRange=predictionRepository.findFirstByDistance(parkingMeter.getLat(),parkingMeter.getLon()).array();
            double trafficJam =timeRange[index];
            double distance1=map.get(parkingMeter.getId());
            double price= Double.parseDouble(parkingMeter.getHourlyRate());
            double recommendationIndex=0.3*trafficJam+0.5*distance1+0.2*price;
            parkingMeter.setRecommendationIndex(recommendationIndex);
            min=Math.min(min,recommendationIndex);
            max=Math.max(max,recommendationIndex);
        }
        for(ParkingMeters parkingMeter: parkingMeters){
            Double recommendationIndex=parkingMeter.getRecommendationIndex();
            if(max==min){
                parkingMeter.setRecommendationIndex(5.0);
                break;
            }
            recommendationIndex=4*(recommendationIndex-min)/(max-min)+1;
            parkingMeter.setRecommendationIndex(recommendationIndex);
        }
        Collections.sort(parkingMeters, new Comparator<ParkingMeters>() {
            @Override
            public int compare(ParkingMeters o1, ParkingMeters o2) {
                if((o1.getRecommendationIndex()-o2.getRecommendationIndex())==0){
                    return 0;
                }
                return o1.getRecommendationIndex()-o2.getRecommendationIndex()>0 ? -1 : 1;
            }
        });
        if(parkingMeters.size()<=5) {
            for(int i=0; i<parkingMeters.size(); i++){
                parkingMeters.get(i).setId(i);
            }
            return parkingMeters;
        }
        List<ParkingMeters> list=new ArrayList<>();
        for(int i=0; i<5; i++){
            ParkingMeters item=parkingMeters.get(i).setId(i);
            list.add(item);
        }
        return list;
    }
    public List<PublicParking> searchPublicParkings(String parkingDate, String parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        //connect with prediction model
        //save predicted data to elastic search and find by location
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        Map<Integer,Double> map=new HashMap<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId());
            map.put(parkingSpot.getId(),parkingSpot.getDistance());
        }
        List<PublicParking> publicParkings=searchParkingStructure.findAllByIdIn(ids);
        String[] splitString=parkingTime.split(":");
        if(splitString[0].startsWith("0")){
            splitString[0]=splitString[0].substring(1,2);
        }
        int index=Integer.parseInt(splitString[0])*2+(Integer.parseInt(splitString[1])==30 ? 1 : 0);
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;
        for(PublicParking publicParking: publicParkings){
            Double[] timeRange=predictionRepository.findFirstByDistance(publicParking.getLat(),publicParking.getLon()).array();
            double trafficJam =timeRange[index];
            double distance1=map.get(publicParking.getId());
            double price= Double.parseDouble(publicParking.getHourlyRate());
            double recommendationIndex=0.3*trafficJam+0.5*distance1+0.2*price+(publicParking.getEvCharging().equals("Yes") ? 1 : 0);
            publicParking.setRecommendationIndex(recommendationIndex);
            min=Math.min(min,recommendationIndex);
            max=Math.max(max,recommendationIndex);
        }
        for(PublicParking publicParking: publicParkings){
            double recommendationIndex=publicParking.getRecommendationIndex();
            if(max==min){
                publicParking.setRecommendationIndex(5.0);
                break;
            }
            recommendationIndex=4*(recommendationIndex-min)/(max-min)+1;
            publicParking.setRecommendationIndex(recommendationIndex);
        }
        Collections.sort(publicParkings, new Comparator<PublicParking>() {
            @Override
            public int compare(PublicParking o1, PublicParking o2) {
                if((o1.getRecommendationIndex()-o2.getRecommendationIndex())==0){
                    return 0;
                }
                return o1.getRecommendationIndex()-o2.getRecommendationIndex()>0 ? -1 : 1;
            }
        });
        if(publicParkings.size()<=5) {
            for(int i=0; i<publicParkings.size(); i++){
                publicParkings.get(i).setId(i);
            }
            return publicParkings;
        }
        List<PublicParking> list=new ArrayList<>();
        for(int i=0; i<5; i++){
            PublicParking item=publicParkings.get(i).setId(i);
            list.add(item);

        }
        return list;
    }
    public List<ParkingSigns> searchParkingSigns(String parkingDate, String parkingTime,double lat, double lon, String distance) {

        List<ParkingSpot> parkingSpots = locationRepository.searchByDistance(lat, lon, distance);
        //connect with prediction model
        //save predicted data to elastic search and find by location
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> ids=new ArrayList<>();
        Map<Integer,Double> map=new HashMap<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            ids.add(parkingSpot.getId());
            map.put(parkingSpot.getId(),parkingSpot.getDistance());
        }
        List<ParkingSigns> parkingSigns=searchParkingSigns.findAllByIdIn(ids);
        String[] splitString=parkingTime.split(":");
        if(splitString[0].startsWith("0")){
            splitString[0]=splitString[0].substring(1,2);
        }
        int index=Integer.parseInt(splitString[0])*2+(Integer.parseInt(splitString[1])==30 ? 1 : 0);
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;
        for(ParkingSigns parkingSign: parkingSigns){
                Double[] timeRange=predictionRepository.findFirstByDistance(parkingSign.getLat(),parkingSign.getLon()).array();
                double trafficJam =timeRange[index];
                double distance1=map.get(parkingSign.getId());
                double recommendationIndex=0.4*trafficJam+0.6*distance1;
                parkingSign.setRecommendationIndex(recommendationIndex);
                min=Math.min(min,recommendationIndex);
                max=Math.max(max,recommendationIndex);
        }
        for(ParkingSigns parkingSign: parkingSigns){
            for(int i=0; i<parkingSign.getSign().length(); i++){
                if(Character.isDigit(parkingSign.getSign().charAt(i))){
                    double recommendationIndex=parkingSign.getRecommendationIndex();
                    if(max==min){
                        parkingSign.setRecommendationIndex(5.0);
                        break;
                    }
                    recommendationIndex=4*(recommendationIndex-min)/(max-min)+1;
                    parkingSign.setRecommendationIndex(recommendationIndex);
                    break;
                }
            }
        }
        Collections.sort(parkingSigns, new Comparator<ParkingSigns>() {
            @Override
            public int compare(ParkingSigns o1, ParkingSigns o2) {
                if((o1.getRecommendationIndex()-o2.getRecommendationIndex())==0){
                    return 0;
                }
                return o1.getRecommendationIndex()-o2.getRecommendationIndex()>0 ? -1 : 1;
            }
        });
        if(parkingSigns.size()<=5) {
            for(int i=0; i<parkingSigns.size(); i++){
                parkingSigns.get(i).setId(i);
            }
            return parkingSigns;
        }
        List<ParkingSigns> list=new ArrayList<>();
        for(int i=0; i<5; i++){
            ParkingSigns item=parkingSigns.get(i).setId(i);
            list.add(item);
        }
        return list;
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
