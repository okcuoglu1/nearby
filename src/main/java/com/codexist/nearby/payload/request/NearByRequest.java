package com.codexist.nearby.payload.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NearByRequest {

    @Range(min = -90, max = 90, message = "Latitude must be between -90 and 90")
    @NotNull(message = "Location latitude must be provided")
    double latitude;

    @Range(min = -180, max = 180, message = "Longitude must be between -180 and 180")
    @NotNull(message = "Location longitude must be provided")
    double longitude;


    @NotNull(message = "Radius must be provided")
    @Positive(message = "Radius must be positive value")
    int radius;

}
