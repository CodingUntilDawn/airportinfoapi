package com.foreflight.airportinfoapi.services.face;

import org.springframework.stereotype.Component;

@Component
public interface AirportService {
    String getAirport(String airport);
}
