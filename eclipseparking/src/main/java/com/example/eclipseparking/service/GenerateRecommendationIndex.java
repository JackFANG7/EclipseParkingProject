package com.example.eclipseparking.service;

import com.example.eclipseparking.model.Prediction;
import com.example.eclipseparking.repository.PredictionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateRecommendationIndex {
    private final PredictionRepository predictionRepository;
    public GenerateRecommendationIndex(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }
    public Double[] getPrediction(Double lat, Double lon){
        Prediction prediction=predictionRepository.findFirstByDistance(lat,lon);
        return prediction.array();
    }

}
