package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.models.weather.WeatherWrapperModel;
import com.foreflight.airportinfoapi.services.face.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public WeatherWrapperModel getWeatherByAirport(String airport) {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        WeatherWrapperModel weatherModel = new WeatherWrapperModel();

        try {
            weatherModel =
                    restTemplate.getForObject(
                            "https://qa.foreflight.com/weather/report/{airport}",
                            WeatherWrapperModel.class, airport
                    );
        }catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc){

        }

        return weatherModel;
    }

}
