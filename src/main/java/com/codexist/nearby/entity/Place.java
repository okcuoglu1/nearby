package com.codexist.nearby.entity;

import com.codexist.nearby.entity.google_response.Geometry;
import com.codexist.nearby.entity.google_response.PlusCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "place")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place implements Serializable {

    @Id
    String id;


    private Geometry geometry;

    private PlusCode plus_code;

    private String business_status;
    private String name;
    private double rating;
    private String reference;
    private String scope;

    private List<String> types;

    private int user_ratings_total;
    private String vicinity;
    private String place_id;


    @DBRef
    List<Query> queries;

}
