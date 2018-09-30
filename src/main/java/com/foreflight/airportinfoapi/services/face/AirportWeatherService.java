package com.foreflight.airportinfoapi.services.face;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AirportWeatherService {

    AirportWeatherModel getAirportWeatherByAirport(String identifier);
    List<AirportWeatherModel> getAirportWeathersByAirports(List<String> identifiers);
}
