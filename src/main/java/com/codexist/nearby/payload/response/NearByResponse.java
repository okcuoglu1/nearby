package com.codexist.nearby.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NearByResponse {

    private String id;
    private double lat;
    private double lng;
    private String place_id;
    private String name;



}
