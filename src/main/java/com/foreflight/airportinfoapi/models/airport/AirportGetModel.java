package com.foreflight.airportinfoapi.models.airport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportGetModel implements Serializable {
    @JsonProperty("results")
    private AirportGetResultsModel results;

    public AirportGetResultsModel getAirportGetResultsModel() {
        return results;
    }

    public void setAirportGetResultsModel(AirportGetResultsModel airportGetResultsModel) {
        this.results = airportGetResultsModel;
    }
}
