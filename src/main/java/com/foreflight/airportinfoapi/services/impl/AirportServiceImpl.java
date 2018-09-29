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
    public String getAirport(String airport){
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String tempReturn;

        try {
            AirportWrapperModel airportModel  =
                    restTemplate.getForObject(
                            "https://qa.foreflight.com/airports/{airport}",
                            AirportWrapperModel.class, airport
                    );

            tempReturn=airportModel.getAirport().getAirportGetResultsModel().getName();
        }catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {

            tempReturn = httpClientOrServerExc.getMessage();

        }
        return tempReturn;
    }
}
