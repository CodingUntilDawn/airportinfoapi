package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VisibilityModel {
    @JsonProperty("distanceSm")
    private int distanceSM;

    @JsonProperty("prevailingVisSm")
    private int prevailingVisSm;

    public int getDistanceSM() {
        return distanceSM;
    }

    public void setDistanceSM(int distanceSM) {
        this.distanceSM = distanceSM;
    }

    public int getPrevailingVisSm() {
        return prevailingVisSm;
    }

    public void setPrevailingVisSm(int prevailingVisSm) {
        this.prevailingVisSm = prevailingVisSm;
    }
}
