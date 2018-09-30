package com.foreflight.airportinfoapi.models.airport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
* The requirements did not specify how much information about
* the runway to include so I am picking a handful of elements.
* If more are required they would simply be added here.
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunwayModel {
    @JsonProperty("ident")
    private String identifier;

    @JsonProperty("name")
    private String name;

    @JsonProperty("approachSlopeSideBase")
    private String approachSlopeSideBase;

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

    public String getApproachSlopeSideBase() {
        return approachSlopeSideBase;
    }

    public void setApproachSlopeSideBase(String approachSlopeSideBase) {
        this.approachSlopeSideBase = approachSlopeSideBase;
    }
}
