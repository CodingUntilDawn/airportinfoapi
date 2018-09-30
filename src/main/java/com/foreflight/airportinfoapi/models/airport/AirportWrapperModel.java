package com.foreflight.airportinfoapi.models.airport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportWrapperModel implements Serializable {
    @JsonProperty("airport")
    private AirportModel airport;

    public AirportModel getAirportModel() {
        return airport;
    }

    public void setAirportModel(AirportModel airport) {
        this.airport = airport;
    }
}
