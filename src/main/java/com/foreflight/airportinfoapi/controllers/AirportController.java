package com.foreflight.airportinfoapi.controllers;

import com.foreflight.airportinfoapi.services.face.AirportService;
import com.foreflight.airportinfoapi.services.face.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AirportController {
    @Autowired
    AirportService airportService;

    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/getAirport/{guid}", method = RequestMethod.GET)
    public String getGameById(@PathVariable("guid") String guid){
        System.out.println(guid);
        String airportTest = airportService.getAirport(guid);
        return weatherService.getWeatherByAirport(guid);

    }
}
