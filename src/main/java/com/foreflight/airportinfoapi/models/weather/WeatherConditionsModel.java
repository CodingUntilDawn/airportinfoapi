package com.foreflight.airportinfoapi.models.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherConditionsModel {
    /***
    * Notice that this is Celsius, but the prompt requires Fahrenheit
    * */
    @JsonProperty("tempC")
    private double tempC;

    /***
     * Is this a double or an integer?
     * All examples so far imply integer, but make it a double to cover uncertainty
     */
    @JsonProperty("relativeHumidity")
    private double relativeHumidity;

    @JsonProperty("cloudLayers")
    private CloudLayerModel[] cloudLayerModelV1;

    @JsonProperty("cloudLayersV2")
    private CloudLayerModel[] cloudLayerModelV2;

    @JsonProperty("visibility")
    private VisibilityModel visibilityModel;

    @JsonProperty("wind")
    private WindModel windModel;

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public CloudLayerModel[] getCloudLayerModelV1() {
        return cloudLayerModelV1;
    }

    public void setCloudLayerModelV1(CloudLayerModel[] cloudLayerModelV1) {
        this.cloudLayerModelV1 = cloudLayerModelV1;
    }

    public CloudLayerModel[] getCloudLayerModelV2() {
        return cloudLayerModelV2;
    }

    public void setCloudLayerModelV2(CloudLayerModel[] cloudLayerModelV2) {
        this.cloudLayerModelV2 = cloudLayerModelV2;
    }

    public VisibilityModel getVisibilityModel() {
        return visibilityModel;
    }

    public void setVisibilityModel(VisibilityModel visibilityModel) {
        this.visibilityModel = visibilityModel;
    }

    /*
    * In the final model do I use the wind speed from the conditions or forecast node
    */
    public WindModel getWindModel() {
        return windModel;
    }

    public void setWindModel(WindModel windModel) {
        this.windModel = windModel;
    }

    public double getTempF(){
        return (9/5) * getTempC() + 32;
    }
}
