package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
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

    @Override
    public AirportWeatherModel getAirportWeatherByAirport(String identifier) {
        AirportWrapperModel airportWrapperModel = airportService.getAirport(identifier);
        WeatherWrapperModel weatherWrapperModel = weatherService.getWeatherByAirport(identifier);

        AirportWeatherModel airportWeatherModel = new AirportWeatherModel(airportWrapperModel, weatherWrapperModel);
        return airportWeatherModel;
    }


}
