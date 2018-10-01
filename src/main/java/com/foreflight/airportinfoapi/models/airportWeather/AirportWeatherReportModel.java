package com.foreflight.airportinfoapi.models.airportWeather;

import java.util.List;

public class AirportWeatherReportModel {
    private double tempF;

    private double relativeHumidity;

    private String cloudCoverageSummary;

    private int visibility;

    private double windSpeed;

    private int windDirection;

    private List<AirportWeatherForecastModel> forecasts;

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
}
