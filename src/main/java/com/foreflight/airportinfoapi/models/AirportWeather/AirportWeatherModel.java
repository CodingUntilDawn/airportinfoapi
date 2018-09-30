package com.foreflight.airportinfoapi.models.AirportWeather;

import com.foreflight.airportinfoapi.models.airport.RunwayModel;

import java.util.List;

public class AirportWeatherModel {
    private String identifier;

    private String name;

    private RunwayModel[] runways;

    private double latitude;

    private double longitude;

    private double tempF;

    private double relativeHumidity;

    private String cloudCoverageSummary;

    private int visibility;

    private double windSpeed;

    private int windDirection;

    private List<AirportWeatherForecastModel> forecasts;

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

    public RunwayModel[] getRunways() {
        return runways;
    }

    public void setRunways(RunwayModel[] runways) {
        this.runways = runways;
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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public List<AirportWeatherForecastModel> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<AirportWeatherForecastModel> forecasts) {
        this.forecasts = forecasts;
    }

    public AirportWeatherModel(){

    }
}
