package com.foreflight.airportinfoapi.models.weather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastModel {
    @JsonProperty("period")
    private ForecastPeriodModel period;

    @JsonProperty("conditions")
    private ForecastConditionsModel[] forecastConditionsModels;

    public ForecastPeriodModel getPeriod() {
        return period;
    }

    public void setPeriod(ForecastPeriodModel period) {
        this.period = period;
    }

    public ForecastConditionsModel[] getForecastConditionsModels() {
        return forecastConditionsModels;
    }

    public void setForecastConditionsModels(ForecastConditionsModel[] forecastConditionsModels) {
        this.forecastConditionsModels = forecastConditionsModels;
    }
}
