package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.airport.AirportWrapperModel;
import com.foreflight.airportinfoapi.services.face.AirportService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class AirportServiceImpl implements AirportService {
    @Override
    public AirportWrapperModel getAirport(String airport){
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        AirportWrapperModel airportModel;

        try {
            airportModel  =
                    restTemplate.getForObject(
                            "https://qa.foreflight.com/airports/{airport}",
                            AirportWrapperModel.class, airport
                    );
        }catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            throw new RuntimeException("The airport endpoint is not reachable");
        }
        return airportModel;
    }
}
