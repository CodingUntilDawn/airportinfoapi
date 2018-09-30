package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.weather.CloudLayerModel;
import org.springframework.stereotype.Service;

@Service
public class CloudCoverageService {
    /*
    * The prompt stated to return "the greatest amount of coverage listed if any." I am not certain how to handle this.
    * Each cloud layer contains multiple altitudes and each altitude seems important.  I am determining if V1 or V2 has
    * the greater value (they appear to always be equal, but I cannot assume that) and then generating a complete
    * description of the cloud coverage at each altitude.
    * */
    public String determineCloudCoverageSummary(CloudLayerModel[] cloudLayerModelV1, CloudLayerModel[] cloudLayerModelV2){
        int v1Value=0, v2Value=0;
        //convert these to lamdba expressions if time permits
        for(int i = 0; i< cloudLayerModelV1.length; i++){
            v1Value+=getOktaValue(cloudLayerModelV1[i].getCoverage());
        }
        for(int j = 0; j< cloudLayerModelV2.length; j++){
            v2Value+=getOktaValue(cloudLayerModelV2[j].getCoverage());
        }

        String summary ="";
        if(v1Value>v2Value){
            for(int i = 0; i< cloudLayerModelV1.length; i++){
                summary+=String.format("The coverage at altitude %d Ft is %s.  ", cloudLayerModelV1[i].getAltitudeFt(), cloudLayerModelV1[i].getCoverage());
            }
        }else{
            for(int j = 0; j< cloudLayerModelV1.length; j++){
                summary+=String.format("The coverage at altitude %d Ft is %s", cloudLayerModelV2[j].getAltitudeFt(), cloudLayerModelV2[j].getCoverage());
            }
        }

        return summary;
    }

    /*
     * Values taken from https://en.wikipedia.org/wiki/Okta
     * The highest possible value was chosen for each key
     */
    public int getOktaValue(String key){
        switch (key.toLowerCase()){
            case "skc":
                return 0;
            case "few":
                return 2;
            case "sct":
                return 4;
            case "bkn":
                return 7;
            case "ovc":
                return 8;
            case "nsc":
                return 9;
            default: //invalid input
                return 99;
        }
    }
}
