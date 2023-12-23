package task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class WebPageSaver {
    private static final String DIRECTORY_PATH = "src/main/resources/";

    public static void saveWebPage(String url, String fileName) {
        try {
            HttpClient httpClient = HttpClient.newBuilder().build();

            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            handleResponse(httpResponse, fileName);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void handleResponse(HttpResponse<String> httpResponse, String fileName) throws IOException {
        int statusCode = httpResponse.statusCode();
        if (statusCode == 200) {
            String responseBody = httpResponse.body();

            saveToFile(responseBody, DIRECTORY_PATH + fileName);
            System.out.println("Strona zapisana jako " + fileName);
        } else {
            System.out.println("Błąd podczas pobierania strony. Kod stanu: " + statusCode);
        }
    }

    private static void saveToFile(String content, String filePath) throws IOException {
        Path path = Path.of(filePath);
        BufferedWriter writer = Files.newBufferedWriter(path);

        writer.write(content);
        writer.close();
    }

    private static void handleException(Exception e) {
        System.out.println("Wystąpił błąd: " + e.getMessage());
    }
}