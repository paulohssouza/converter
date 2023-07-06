package br.com.oracle.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Properties;

public class ClientHttp {

    public String fetchData(String apiUrl) {
        Properties connectionProperties = new Properties();
        try{
            InputStream file = new FileInputStream("src/main/java/br/com/oracle/connection.properties");
            connectionProperties.load(file);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        try {
            String pairCoinsUrl = connectionProperties.getProperty("pairCoins");
            String urlCoinsApi = apiUrl + pairCoinsUrl;
            URI uriPairCoins = URI.create(urlCoinsApi);
            HttpClient httpClientPairCoins = HttpClient.newHttpClient();
            HttpRequest requestPairCoins = HttpRequest.newBuilder(uriPairCoins).GET().build();
            HttpResponse<String> responseCoinPairs = httpClientPairCoins.send(requestPairCoins, BodyHandlers.ofString());
            return responseCoinPairs.body();
        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

}
