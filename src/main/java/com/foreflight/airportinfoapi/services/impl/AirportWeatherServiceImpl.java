package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import com.foreflight.airportinfoapi.models.airport.AirportModel;
import com.foreflight.airportinfoapi.models.airport.AirportResultsModel;
import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
import com.foreflight.airportinfoapi.models.weather.VisibilityModel;
import com.foreflight.airportinfoapi.models.weather.WeatherConditionsModel;
import com.foreflight.airportinfoapi.models.weather.WeatherReportModel;
import com.foreflight.airportinfoapi.models.weather.WeatherWrapperModel;
import com.foreflight.airportinfoapi.services.face.AirportService;
import com.foreflight.airportinfoapi.services.face.AirportWeatherService;
import com.foreflight.airportinfoapi.services.face.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportWeatherServiceImpl implements AirportWeatherService {
    @Autowired
    AirportService airportService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    CloudCoverageService cloudCoverageService;

    @Override
    public AirportWeatherModel getAirportWeatherByAirport(String identifier) {
        AirportWrapperModel airportWrapperModel = airportService.getAirport(identifier);
        WeatherWrapperModel weatherWrapperModel = weatherService.getWeatherByAirport(identifier);

        /*
        * Initially I had the following lines in the constructor for airportWeatherModel,
        * but I think there is too much logic here to go into a constructor.  Certain lines like
        * the cloud coverage determination have to be in a service (that line calls a helper class
        * and that is definitely too much for a constructor) so I moved all the setting logic into
        * the service.  If the team prefers these lines to be in the constructor though that is fine.
        * This is just a personal preference.
        */
        AirportWeatherModel airportWeatherModel = new AirportWeatherModel();
        AirportModel airportModel = airportWrapperModel.getAirportModel();
        if(airportModel!=null) {
            AirportResultsModel airportResultsModel = airportModel.getAirportResultsModel();
            if(airportResultsModel!=null) {
                airportWeatherModel.setIdentifier(airportResultsModel.getIdentifier());
                airportWeatherModel.setName(airportResultsModel.getName());
                airportWeatherModel.setLatitude(airportResultsModel.getLatitude());
                airportWeatherModel.setLongitude(airportResultsModel.getLongitude());
            }
        }

        WeatherReportModel weatherReportModel = weatherWrapperModel.getWeatherReportModel();
        if(weatherReportModel!=null){
            WeatherConditionsModel weatherConditionsModel = weatherReportModel.getConditions();
            if(weatherConditionsModel!=null){
                airportWeatherModel.setTempF(weatherConditionsModel.getTempF());
                airportWeatherModel.setRelativeHumidity(weatherConditionsModel.getRelativeHumidity());

                String cloudCoverageSummary = cloudCoverageService.determineCloudCoverageSummary(weatherConditionsModel.getCloudLayerModelV1(), weatherConditionsModel.getCloudLayerModelV2());
                airportWeatherModel.setCloudCoverageSummary(cloudCoverageSummary);

                VisibilityModel visibilityModel = weatherConditionsModel.getVisibilityModel();
                if(visibilityModel!=null) {
                    //is DistanceSM or prevailingVisSm correct?  assume DistanceSM until confirmed
                    airportWeatherModel.setVisibility(visibilityModel.getDistanceSM());
                }
            }
        }
        return airportWeatherModel;
    }


}
