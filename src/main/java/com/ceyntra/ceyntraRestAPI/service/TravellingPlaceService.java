package com.ceyntra.ceyntraRestAPI.service;

import com.ceyntra.ceyntraRestAPI.model.CoordinatesModel;
import com.ceyntra.ceyntraRestAPI.model.RapidApiModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TravellingPlaceService {

    @Autowired
    ApiKeyService apiKeyService;

    public int calculateDistanceBetweenTwoPlaces(CoordinatesModel currentPlace, CoordinatesModel otherPlace) throws IOException, InterruptedException {
        String url = "https://distance-calculator.p.rapidapi.com/v1/one_to_one?start_point=(" + currentPlace.getLatitude() + "%2C" + currentPlace.getLongitude() + ")&end_point=(" + otherPlace.getLatitude() + "%2C" +otherPlace.getLongitude() + ")&unit=kilometers";
        System.out.println("hellooooooo");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("content-type", "application/json")
                .header("x-rapidapi-host", "distance-calculator.p.rapidapi.com")
                .header("x-rapidapi-key", apiKeyService.getRapidApiKey())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        RapidApiModel rapidApiModel = objectMapper.readValue(response.body(), RapidApiModel.class);

        return (int) (rapidApiModel.getDistance());
    }
}
