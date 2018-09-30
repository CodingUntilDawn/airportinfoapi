package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindModel {
    @JsonProperty("speedKts")
    private int speedKts;

    @JsonProperty("variable")
    private boolean variable;

    public int getSpeedKts() {
        return speedKts;
    }

    public void setSpeedKts(int speedKts) {
        this.speedKts = speedKts;
    }

    public boolean isVariable() {
        return variable;
    }

    public void setVariable(boolean variable) {
        this.variable = variable;
    }
}
