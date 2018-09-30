package com.foreflight.airportinfoapi.models.AirportWeather;

import com.foreflight.airportinfoapi.models.weather.WindModel;

public class AirportWeatherForecastModel {
    private String timeOffset;

    private double temperatureF;

    private WindModel wind;

    public String getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(String timeOffset) {
        this.timeOffset = timeOffset;
    }

    public double getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(double temperatureF) {
        this.temperatureF = temperatureF;
    }

    public WindModel getWind() {
        return wind;
    }

    public void setWind(WindModel wind) {
        this.wind = wind;
    }
}
