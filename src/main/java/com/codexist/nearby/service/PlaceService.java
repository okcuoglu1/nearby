package com.codexist.nearby.service;

import com.codexist.nearby.entity.Place;
import com.codexist.nearby.entity.Query;
import com.codexist.nearby.mapper.NearByMapper;
import com.codexist.nearby.payload.googleapiresult.PlaceResult;
import com.codexist.nearby.payload.request.NearByRequest;
import com.codexist.nearby.payload.response.NearByResponse;
import com.codexist.nearby.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final RestTemplate restTemplate;

    private final NearByMapper mapper;

    private final QueryService queryService;

    @Value("${google.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";


    public ResponseEntity<List<NearByResponse>> getNearbyPlaces(NearByRequest request) {

        Query existingQuery = queryService.findQuery(request);

        if (existingQuery != null) {

            System.out.println("BU KISIM CALISTI - DB DEN DATA ÇEKİLDİ");
            List<Place> places = existingQuery.getPlaces();
            return ResponseEntity.ok(places.stream().map(mapper::buildNearByResponse).collect(Collectors.toList()));

        }


        String url = BASE_URL +
                "?location=" + request.getLatitude() + "," + request.getLongitude() +
                "&radius=" + request.getRadius() +
                "&key=" + apiKey;

        PlaceResult placeResult = restTemplate.getForObject(url, PlaceResult.class);

        List<Place> places = placeResult.getResults();

        List<Place> savedPlaces = placeRepository.saveAll(places);



        Query newQuery = queryService.saveQuery(request);
        newQuery.setPlaces(savedPlaces);

        queryService.updateQuery(newQuery);

        return ResponseEntity.ok(savedPlaces.stream().map(mapper::buildNearByResponse).collect(Collectors.toList()));


    }
}
