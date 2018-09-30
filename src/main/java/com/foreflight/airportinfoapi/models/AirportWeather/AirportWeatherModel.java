package com.foreflight.airportinfoapi.models.AirportWeather;

import com.foreflight.airportinfoapi.models.airport.AirportModel;
import com.foreflight.airportinfoapi.models.airport.AirportResultsModel;
import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
import com.foreflight.airportinfoapi.models.weather.WeatherWrapperModel;

public class AirportWeatherModel {
    private String identifier;

    private String name;

    private double latitude;

    private double longitude;

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

    public AirportWeatherModel(AirportWrapperModel airportWrapperModel, WeatherWrapperModel weatherWrapperModel){
        AirportModel airportModel = airportWrapperModel.getAirportModel();
        if(airportModel!=null) {
            AirportResultsModel airportResultsModel = airportModel.getAirportResultsModel();
            if(airportResultsModel!=null) {
                setIdentifier(airportResultsModel.getIdentifier());
                setName(airportResultsModel.getName());
                setLatitude(airportResultsModel.getLatitude());
                setLongitude(airportResultsModel.getLongitude());
            }
        }
    }
}
