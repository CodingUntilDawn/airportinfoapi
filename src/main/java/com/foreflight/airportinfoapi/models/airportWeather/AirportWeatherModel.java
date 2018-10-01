package com.foreflight.airportinfoapi.models.airportWeather;

import com.foreflight.airportinfoapi.models.airport.RunwayModel;

public class AirportWeatherModel {
    private String identifier;

    private String name;

    private RunwayModel[] runways;

    private double latitude;

    private double longitude;

    private AirportWeatherReportModel weatherReport;

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

    public AirportWeatherReportModel getWeatherReport() {
        return weatherReport;
    }

    public void setWeatherReport(AirportWeatherReportModel weatherReport) {
        this.weatherReport = weatherReport;
    }

    public AirportWeatherModel(){

    }
}
