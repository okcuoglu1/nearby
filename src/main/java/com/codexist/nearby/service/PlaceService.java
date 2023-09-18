package com.codexist.nearby.service;

import com.codexist.nearby.entity.Place;
import com.codexist.nearby.payload.googleapiresult.PlaceResult;
import com.codexist.nearby.payload.request.NearByRequest;
import com.codexist.nearby.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final RestTemplate restTemplate;

    @Value("${google.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";


    public ResponseEntity getNearbyPlaces(NearByRequest request) {


        String url = BASE_URL +
                "?location=" + request.getLatitude() + "," + request.getLongitude() +
                "&radius=" + request.getRadius() +
                "&key=" + apiKey;

        PlaceResult placeResult = restTemplate.getForObject(url, PlaceResult.class);

        List<Place> places = placeResult.getResults();

        List<Place> savedPlaces = placeRepository.saveAll(places);


    }
}
