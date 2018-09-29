package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherWrapperModel {
    @JsonProperty("report")
    private WeatherReportModel report;

    public WeatherReportModel getWeatherReportModel() {
        return report;
    }

    public void setWeatherReportModel(WeatherReportModel weatherReportModel) {
        this.report = weatherReportModel;
    }
}
