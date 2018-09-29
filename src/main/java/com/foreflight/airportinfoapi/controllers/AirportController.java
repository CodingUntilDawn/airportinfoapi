package com.foreflight.airportinfoapi.controllers;

import com.foreflight.airportinfoapi.services.face.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AirportController {
    @Autowired
    AirportService airportService;

    @RequestMapping(value = "/getAirport/{guid}", method = RequestMethod.GET)
    public String getGameById(@PathVariable("guid") String guid){
        System.out.println(guid);
        try {
            return airportService.getAirport(guid);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
            //This is not best practice.  I will change this to return a status code later.
            return  exception.getMessage();
        }
    }
}
