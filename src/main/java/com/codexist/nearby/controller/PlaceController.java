package com.codexist.nearby.controller;

import com.codexist.nearby.payload.request.NearByRequest;
import com.codexist.nearby.payload.response.NearByResponse;
import com.codexist.nearby.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;


    @GetMapping("/nearby")
    public ResponseEntity<List<NearByResponse>> getNearbyPlaces(@RequestParam("latitude") double latitude,
                                                                @RequestParam("longitude") double longitude,
                                                                @RequestParam("radius") int radius) {

        NearByRequest request = NearByRequest.builder().latitude(latitude).longitude(longitude).radius(radius).build();

        return placeService.getNearbyPlaces(request);
    }

}
