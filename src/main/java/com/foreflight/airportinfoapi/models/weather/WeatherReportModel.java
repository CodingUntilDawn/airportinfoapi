package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReportModel {
    @JsonProperty("conditions")
    private WeatherConditionsModel conditions;

    public WeatherConditionsModel getConditions() {
        return conditions;
    }

    public void setConditions(WeatherConditionsModel conditions) {
        this.conditions = conditions;
    }
}
