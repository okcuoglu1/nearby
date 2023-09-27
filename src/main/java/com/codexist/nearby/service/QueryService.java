package com.codexist.nearby.service;

import com.codexist.nearby.entity.Query;
import com.codexist.nearby.payload.request.NearByRequest;
import com.codexist.nearby.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryService {

    private final QueryRepository queryRepository;

    public Query findQuery(NearByRequest request) {


        return queryRepository.findByLatitudeAndLongitudeAndRadius(
                request.getLatitude(), request.getLongitude(), request.getRadius()
        ).orElse(null);
    }

    public Query saveQuery(NearByRequest request) {


        Query query = Query.builder()
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .radius(request.getRadius())
                .build();
        return queryRepository.save(query);
    }

    public Query updateQuery(Query query) {

        return queryRepository.save(query);

    }



}
