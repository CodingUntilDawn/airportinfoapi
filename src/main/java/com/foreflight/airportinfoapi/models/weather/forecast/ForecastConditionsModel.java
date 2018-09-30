package com.foreflight.airportinfoapi.models.weather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foreflight.airportinfoapi.models.weather.WindModel;

public class ForecastConditionsModel {
    @JsonProperty("wind")
    private WindModel windModel;

    /*
    * The prompt states that there should be a temperature value in this node,
    * but it has not been present in any of the airports I have checked.  (Austin,
    * Denver, Seattle, Phoenix, Kansas City).  I will put the value here to follow
    * the prompt, but I don't think it will ever be set.
    */
    @JsonProperty("tempC")
    private double tempC;

    @JsonProperty("period")
    private ForecastPeriodModel periodModel;

    public WindModel getWindModel() {
        return windModel;
    }

    public void setWindModel(WindModel windModel) {
        this.windModel = windModel;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public ForecastPeriodModel getPeriodModel() {
        return periodModel;
    }

    public void setPeriodModel(ForecastPeriodModel periodModel) {
        this.periodModel = periodModel;
    }
}
