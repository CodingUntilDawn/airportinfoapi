package com.foreflight.airportinfoapi.services.impl;

import com.foreflight.airportinfoapi.services.face.AirportService;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AirportServiceImpl implements AirportService {
    @Override
    public String getAirport(String airport) throws IOException {
        //change this to be pulled from a config file
        String url = String.format("https://qa.foreflight.com/weather/report/%s", airport);
        HttpURLConnection con = null;
        String tempReturn = "testing";

        try {
            URL airportUrl = new URL(url);
            con = (HttpURLConnection) airportUrl.openConnection();
            con.setRequestMethod("GET");

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            tempReturn = content.toString();
        } finally {
            con.disconnect();
        }

        return tempReturn;
    }
}
