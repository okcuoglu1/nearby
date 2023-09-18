package com.codexist.nearby.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "query")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Query implements Serializable {

    @Id
    String id;

    double latitude;

    double longitude;

    int radius;


    @DBRef
    List<Place> places;

}