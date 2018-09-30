package com.foreflight.airportinfoapi.models.weather;

/*
*   Summary of cloud coverage (text string) - This is the greatest amount of coverage listed if any
*   The prompt does not specify if cloudLayers or cloudLayersV2 should be used.  Assume that V1 and V2
*   are not guaranteed to be the same and create a comparison helper for them based off of the coverage
*   intensity.  The one with "more coverage" will be returned to the user
*/

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloudLayerModel {
    @JsonProperty("coverage")
    private String coverage;

    @JsonProperty("altitudeFt")
    private Integer altitudeFt;

    @JsonProperty("ceiling")
    private Boolean ceiling;

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public Integer getAltitudeFt() {
        return altitudeFt;
    }

    public void setAltitudeFt(Integer altitudeFt) {
        this.altitudeFt = altitudeFt;
    }

    public Boolean getCeiling() {
        return ceiling;
    }

    public void setCeiling(Boolean ceiling) {
        this.ceiling = ceiling;
    }
}
