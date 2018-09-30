package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherForecastModel;
import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherReportModel;
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
            airportWeatherModel = populateAirportInfo(airportWeatherModel, airportResultsModel);
        }

        WeatherReportModel weatherReportModel = weatherWrapperModel.getWeatherReportModel();
        if(weatherReportModel!=null){
            AirportWeatherReportModel airportWeatherReportModel = populateWeatherReportInfo(weatherReportModel);
            airportWeatherModel.setWeatherReport(airportWeatherReportModel);
        }
        return airportWeatherModel;
    }

    @Override
    public List<AirportWeatherModel> getAirportWeathersByAirports(List<String> identifiers) {
        List<AirportWeatherModel> airportWeatherModels = new ArrayList<>();
        for (String identifier :identifiers) {
            airportWeatherModels.add(getAirportWeatherByAirport(identifier));
        }
        return airportWeatherModels;
    }

    private AirportWeatherReportModel populateWeatherReportInfo(WeatherReportModel weatherReportModel) {
        WeatherConditionsModel weatherConditionsModel = weatherReportModel.getConditions();
        AirportWeatherReportModel airportWeatherReportModel = new AirportWeatherReportModel();
        if(weatherConditionsModel!=null){
            airportWeatherReportModel.setTempF(convertToF(weatherConditionsModel.getTempC()));
            airportWeatherReportModel.setRelativeHumidity(weatherConditionsModel.getRelativeHumidity());

            String cloudCoverageSummary = cloudCoverageService.determineCloudCoverageSummary(weatherConditionsModel.getCloudLayerModelV1(), weatherConditionsModel.getCloudLayerModelV2());
            airportWeatherReportModel.setCloudCoverageSummary(cloudCoverageSummary);

            VisibilityModel visibilityModel = weatherConditionsModel.getVisibilityModel();
            if(visibilityModel!=null) {
                //is DistanceSM or prevailingVisSm correct?  assume DistanceSM until confirmed
                airportWeatherReportModel.setVisibility(visibilityModel.getDistanceSM());
            }

            WindModel windModel = weatherConditionsModel.getWindModel();
            if(windModel!=null) {
                airportWeatherReportModel.setWindSpeed(windModel.getSpeedKts());
                airportWeatherReportModel.setWindDirection(windModel.getDirection());
            }

            ForecastModel forecastModel = weatherReportModel.getForecastModel();
            if(forecastModel!=null){
                List<AirportWeatherForecastModel> airportWeatherForecastModels= new ArrayList<>();
                airportWeatherForecastModels = populateAirportWeatherForecastInfo(forecastModel, airportWeatherForecastModels, 1);
                airportWeatherForecastModels = populateAirportWeatherForecastInfo(forecastModel, airportWeatherForecastModels, 2);

                airportWeatherReportModel.setForecasts(airportWeatherForecastModels);
            }
        }
        return airportWeatherReportModel;
    }

    private AirportWeatherModel populateAirportInfo(AirportWeatherModel airportWeatherModel, AirportResultsModel airportResultsModel) {
        if(airportResultsModel!=null) {
            airportWeatherModel.setIdentifier(airportResultsModel.getIdentifier());
            airportWeatherModel.setName(airportResultsModel.getName());
            airportWeatherModel.setLatitude(airportResultsModel.getLatitude());
            airportWeatherModel.setLongitude(airportResultsModel.getLongitude());
            airportWeatherModel.setRunways(airportResultsModel.getRunwayModels());
        }
        return airportWeatherModel;
    }

    private List<AirportWeatherForecastModel> populateAirportWeatherForecastInfo(ForecastModel forecastModel, List<AirportWeatherForecastModel> airportWeatherForecastModels, int searchIndex){
        new ArrayList<>();
        ForecastConditionsModel[] forecastConditionsModel = forecastModel.getForecastConditionsModels();
        if(forecastConditionsModel.length>= (searchIndex+1)){
            AirportWeatherForecastModel airportWeatherForecastModel = new AirportWeatherForecastModel();

            ForecastPeriodModel forecastPeriodModel = forecastConditionsModel[searchIndex].getPeriodModel();
            if(forecastPeriodModel != null) {
                ZoneOffset offset1 = ZoneOffset.systemDefault().getRules().getOffset(forecastPeriodModel.getDateStart().toInstant());
                airportWeatherForecastModel.setTimeOffset(offset1.getId());
            }
            //convert from C to F
            airportWeatherForecastModel.setTemperatureF(convertToF(forecastConditionsModel[searchIndex].getTempC()));
            airportWeatherForecastModel.setWind(forecastConditionsModel[searchIndex].getWindModel());
            airportWeatherForecastModels.add(airportWeatherForecastModel);
        }
        return airportWeatherForecastModels;
    }

    public double convertToF(double tempC){
        return 32 + (tempC * 9/5);
    }
}
