package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class SumClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        List<Integer> numbersToSend = Arrays.asList(1, 2, 3, 4, 5);

        String numbersAsString = String.join(",", numbersToSend.stream().map(String::valueOf).toArray(String[]::new));

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/sum?numbers=" + numbersAsString))
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (httpResponse.statusCode() == 200) {
            int sum = Integer.parseInt(httpResponse.body());
            System.out.println("Suma liczb: " + sum);
        } else {
            System.out.println("Wystąpił błąd. Kod odpowiedzi: " + httpResponse.statusCode());
        }
    }
}