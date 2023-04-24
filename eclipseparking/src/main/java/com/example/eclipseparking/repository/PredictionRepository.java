package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction,Integer> {
    @Query(value = "SELECT * FROM prediction " +
            "ORDER BY " +
            "    (6371 * " +
            "        acos(" +
            "            cos(radians(:latitude)) " +
            "            * cos(radians(lat)) " +
            "            * cos(radians(lon) - radians(:longitude)) " +
            "            + sin(radians(:latitude)) " +
            "            * sin(radians(lat))" +
            "        )" +
            ") " +
            "LIMIT 1",
            nativeQuery = true)
    Prediction findFirstByDistance(double latitude, double longitude);
}

