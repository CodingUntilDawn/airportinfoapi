package com.foreflight.airportinfoapi.services.face;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import org.springframework.stereotype.Component;

@Component
public interface AirportWeatherService {

    AirportWeatherModel getAirportWeatherByAirport(String identifier);

}
