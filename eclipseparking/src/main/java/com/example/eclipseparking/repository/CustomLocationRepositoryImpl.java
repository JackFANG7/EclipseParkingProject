package com.example.eclipseparking.repository;

import com.example.eclipseparking.model.ParkingSpot;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class CustomLocationRepositoryImpl implements CustomLocationRepository {
    private static final String DEFAULT_DISTANCE = "0.5";
    private final ElasticsearchOperations elasticsearchOperations;

    public CustomLocationRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public List<ParkingSpot> searchByDistance(double lat, double lon, String distance) {
        if (distance == null || distance.isEmpty()) {
            distance = DEFAULT_DISTANCE;
        }
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withFilter(new GeoDistanceQueryBuilder("geoPoint").point(lat, lon).distance(distance, DistanceUnit.MILES)).withPageable(PageRequest.of(0, 3000));

        SearchHits<ParkingSpot> searchResult = elasticsearchOperations.search(queryBuilder.build(), ParkingSpot.class);
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (SearchHit<ParkingSpot> hit : searchResult.getSearchHits()) {
            ParkingSpot parkingSpot=hit.getContent();
            double distanceToParkingLot=getDistance(lat,parkingSpot.getGeoPoint().getLat(),lon,parkingSpot.getGeoPoint().getLon());
            parkingSpot.setDistance(distanceToParkingLot);
            parkingSpots.add(parkingSpot);
        }
        return parkingSpots;
    }
    private double getDistance(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000/1600; // convert to miles

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}
