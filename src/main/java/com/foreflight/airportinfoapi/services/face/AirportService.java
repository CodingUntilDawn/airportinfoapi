package com.foreflight.airportinfoapi.services.face;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface AirportService {
    String getAirport(String airport) throws IOException;
}
