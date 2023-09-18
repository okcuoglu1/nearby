package com.codexist.nearby.repository;

import com.codexist.nearby.entity.Query;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QueryRepository extends MongoRepository<Query,String> {
    Optional<Query> findByLatitudeAndLongitudeAndRadius(@NonNull double latitude,@NonNull double longitude,@NonNull int radius);

    boolean existsByLatitudeAndLongitudeAndRadius(double latitude, double longitude, int radius);
}
