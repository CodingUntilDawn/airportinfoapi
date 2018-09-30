package com.foreflight.airportinfoapi.services.face;

import com.foreflight.airportinfoapi.models.weather.WeatherWrapperModel;
import org.springframework.stereotype.Component;

@Component
public interface WeatherService {
    WeatherWrapperModel getWeatherByAirport(String airport);
}
