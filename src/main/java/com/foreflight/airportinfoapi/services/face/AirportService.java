package com.foreflight.airportinfoapi.services.face;

import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
import org.springframework.stereotype.Component;

@Component
public interface AirportService {
    AirportWrapperModel getAirport(String airport);
}
