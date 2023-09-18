package com.codexist.nearby.entity.google_response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Viewport {

    private Northeast northeast;

    private Southwest southwest;



}
