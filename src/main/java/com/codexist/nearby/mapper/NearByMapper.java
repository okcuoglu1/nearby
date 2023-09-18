package com.codexist.nearby.mapper;

import com.codexist.nearby.entity.Place;
import com.codexist.nearby.payload.response.NearByResponse;
import org.springframework.stereotype.Component;

@Component
public class NearByMapper {
    public NearByResponse buildNearByResponse(Place place) {
        return NearByResponse.builder()
                .id(place.getId())
                .lat(place.getGeometry().getLocation().getLat())
                .lng(place.getGeometry().getLocation().getLng())
                .place_id(place.getPlace_id())
                .name(place.getName())
                .build();
    }
}