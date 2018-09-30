package com.foreflight.airportinfoapi.models.AirportWeather;

import com.foreflight.airportinfoapi.models.airport.AirportModel;
import com.foreflight.airportinfoapi.models.airport.AirportResultsModel;
import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
import com.foreflight.airportinfoapi.models.weather.WeatherConditionsModel;
import com.foreflight.airportinfoapi.models.weather.WeatherReportModel;
import com.foreflight.airportinfoapi.models.weather.WeatherWrapperModel;

public class AirportWeatherModel {
    private String identifier;

    private String name;

    private double latitude;

    private double longitude;

    private double tempF;

    private double relativeHumidity;

    private String cloudCoverageSummary;

    private int visibility;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double humidity) {
        this.relativeHumidity = humidity;
    }

    public String getCloudCoverageSummary() {
        return cloudCoverageSummary;
    }

    public void setCloudCoverageSummary(String cloudCoverageSummary) {
        this.cloudCoverageSummary = cloudCoverageSummary;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public AirportWeatherModel(){

    }
}
