package com.foreflight.airportinfoapi.services.face;

import org.springframework.stereotype.Component;

@Component
public interface WeatherService {
    String getWeatherByAirport(String airport);
}
