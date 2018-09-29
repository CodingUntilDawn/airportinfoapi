package com.foreflight.airportinfoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
public class AirportinfoapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportinfoapiApplication.class, args);
    }
}
