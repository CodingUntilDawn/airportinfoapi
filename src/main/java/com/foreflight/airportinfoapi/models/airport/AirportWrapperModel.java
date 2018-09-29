package com.foreflight.airportinfoapi.models.airport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportWrapperModel implements Serializable {
    @JsonProperty("airport")
    private AirportGetModel airport;

    public AirportGetModel getAirport() {
        return airport;
    }

    public void setAirport(AirportGetModel airport) {
        this.airport = airport;
    }
}
