package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.ParkingSpot;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ElasticsearchRepository<ParkingSpot, Integer>,CustomLocationRepository{

}
