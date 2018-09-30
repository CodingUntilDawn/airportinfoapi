package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.foreflight.airportinfoapi.models.weather.forecast.ForecastModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReportModel {
    @JsonProperty("conditions")
    private WeatherConditionsModel conditions;

    @JsonProperty("forecast")
    private ForecastModel forecastModel;

    public WeatherConditionsModel getConditions() {
        return conditions;
    }

    public void setConditions(WeatherConditionsModel conditions) {
        this.conditions = conditions;
    }

    public ForecastModel getForecastModel() {
        return forecastModel;
    }

    public void setForecastModel(ForecastModel forecastModel) {
        this.forecastModel = forecastModel;
    }
}
