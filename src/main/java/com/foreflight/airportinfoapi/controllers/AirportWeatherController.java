package com.foreflight.airportinfoapi.controllers;

import com.foreflight.airportinfoapi.models.AirportWeather.AirportWeatherModel;
import com.foreflight.airportinfoapi.services.face.AirportWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AirportWeatherController {
    @Autowired
    AirportWeatherService airportWeatherService;

    @RequestMapping(value = "/getAirportWeather/{identifier}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public AirportWeatherModel getAirportWeather(@PathVariable("identifier") String identifier){
        //replace these models with a combined model
        AirportWeatherModel airportWeatherModel = airportWeatherService.getAirportWeatherByAirport(identifier);
        return airportWeatherModel;

    }
}
