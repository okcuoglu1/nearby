package com.codexist.nearby.controller;

import com.codexist.nearby.payload.request.NearByRequest;
import com.codexist.nearby.payload.response.NearByResponse;
import com.codexist.nearby.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/nearby")
    public ResponseEntity<List<NearByResponse>> getNearbyPlaces(@RequestBody @Valid NearByRequest request) {
        return placeService.getNearbyPlaces(request);
    }

}
