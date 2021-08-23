package com.ceyntra.ceyntraRestAPI.service;

import com.ceyntra.ceyntraRestAPI.model.CoordinatesModel;
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
                .header("x-rapidapi-host", apiKeyService.getRapidApiKey())
                .header("x-rapidapi-key", "957f428eeamsh9f11a969b3b93eep10b262jsndaac87a7b734")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return 1;
    }
}
