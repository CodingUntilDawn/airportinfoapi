package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherForecastModel;
import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import com.foreflight.airportinfoapi.models.airport.AirportModel;
import com.foreflight.airportinfoapi.models.airport.AirportResultsModel;
import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
import com.foreflight.airportinfoapi.models.weather.*;
import com.foreflight.airportinfoapi.models.weather.forecast.ForecastConditionsModel;
import com.foreflight.airportinfoapi.models.weather.forecast.ForecastModel;
import com.foreflight.airportinfoapi.models.weather.forecast.ForecastPeriodModel;
import com.foreflight.airportinfoapi.services.face.AirportService;
import com.foreflight.airportinfoapi.services.face.AirportWeatherService;
import com.foreflight.airportinfoapi.services.face.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                airportWeatherModel.setRunways(airportResultsModel.getRunwayModels());
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

                WindModel windModel = weatherConditionsModel.getWindModel();
                if(windModel!=null) {
                    airportWeatherModel.setWindSpeed(windModel.getSpeedKts());
                    airportWeatherModel.setWindDirection(windModel.getDirection());
                }

                ForecastModel forecastModel = weatherReportModel.getForecastModel();
                if(forecastModel!=null){
                    List<AirportWeatherForecastModel> airportWeatherForecastModels= new ArrayList<>();
                    ForecastConditionsModel[] forecastConditionsModel = forecastModel.getForecastConditionsModels();
                    if(forecastConditionsModel.length>=2){
                        AirportWeatherForecastModel day2 = new AirportWeatherForecastModel();

                        ForecastPeriodModel forecastPeriodModel = forecastConditionsModel[1].getPeriodModel();
                        if(forecastPeriodModel != null) {
                            ZoneOffset offset1 = ZoneOffset.systemDefault().getRules().getOffset(forecastPeriodModel.getDateStart().toInstant());
                            day2.setTimeOffset(offset1.getId());
                        }
                        //convert from C to F
                        day2.setTemperatureF(forecastConditionsModel[1].getTempC());
                        day2.setWind(forecastConditionsModel[1].getWindModel());
                        airportWeatherForecastModels.add(day2);
                    }
                    if(forecastConditionsModel.length>=3){
                        AirportWeatherForecastModel day3 = new AirportWeatherForecastModel();

                        ForecastPeriodModel forecastPeriodModel = forecastConditionsModel[2].getPeriodModel();
                        if(forecastPeriodModel != null) {
                            ZoneOffset offset1 = ZoneOffset.systemDefault().getRules().getOffset(forecastPeriodModel.getDateStart().toInstant());
                            day3.setTimeOffset(offset1.getId());
                        }
                        //convert from C to F
                        day3.setTemperatureF(forecastConditionsModel[2].getTempC());
                        day3.setWind(forecastConditionsModel[2].getWindModel());
                        airportWeatherForecastModels.add(day3);
                    }
                    airportWeatherModel.setForecasts(airportWeatherForecastModels);
                }
            }
        }
        return airportWeatherModel;
    }


}
