package com.foreflight.airportinfoapi.models.airport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportModel implements Serializable {
    @JsonProperty("results")
    private AirportResultsModel results;

    public AirportResultsModel getAirportResultsModel() {
        return results;
    }

    public void setAirportResultsModel(AirportResultsModel airportResultsModel) {
        this.results = airportResultsModel;
    }
}
