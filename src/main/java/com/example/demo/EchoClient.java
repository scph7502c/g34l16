package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class EchoClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        String textToSend = "Przykładowy tekst";

        String encodedText = URLEncoder.encode(textToSend, StandardCharsets.UTF_8);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/echo?text=" + encodedText))
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = httpResponse.statusCode();
        if (statusCode == 200) {
            String responseText = httpResponse.body();
            System.out.println("Odpowiedź serwera: " + responseText);
        } else {
            System.out.println("Wystąpił błąd. Kod odpowiedzi: " + statusCode);
        }
    }
}