package com.foreflight.airportinfoapi.controllers;

import com.foreflight.airportinfoapi.models.airportWeather.AirportWeatherModel;
import com.foreflight.airportinfoapi.services.face.AirportWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AirportWeatherController {
    @Autowired
    AirportWeatherService airportWeatherService;

    @RequestMapping(value = "/getAirportWeather/{identifier}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportWeatherModel> getAirportWeather(@PathVariable("identifier") String identifier){
        return new ResponseEntity<>(airportWeatherService.getAirportWeatherByAirport(identifier), HttpStatus.OK);
    }

    @RequestMapping(value = "/getMultipleAirportsWeather", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportWeatherModel>> getMultipleAirportsWeather(@RequestBody List<String> identifiers){
        return new ResponseEntity<>(airportWeatherService.getAirportWeathersByAirports(identifiers), HttpStatus.OK);
    }
}
