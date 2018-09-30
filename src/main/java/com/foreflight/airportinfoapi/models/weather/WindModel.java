package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindModel {
    @JsonProperty("speedKts")
    private double speedKts;

    @JsonProperty("direction")
    private int direction;

    public double getSpeedKts() {
        return speedKts;
    }

    public void setSpeedKts(double speedKts) {
        this.speedKts = speedKts;
    }


    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
