package com.foreflight.airportinfoapi.models.weather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ForecastPeriodModel {
    @JsonProperty("dateStart")
    private Date dateStart;

    @JsonProperty("dateEnd")
    private Date dateEnd;

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
