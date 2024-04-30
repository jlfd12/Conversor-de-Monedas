package com.alurachallenge.conversor.conversion;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Cambio{
    public Conversion hazCambio(int opcion, double cantidad){
        String monedaBase = "";
        String monedaTarget = "";

        switch (opcion) {
            case 1:
                monedaBase = "USD";
                monedaTarget = "MXN";
                break;
            case 2:
                monedaBase = "MXN";
                monedaTarget = "USD";
                break;
            case 3:
                monedaBase = "USD";
                monedaTarget = "BRL";
                break;
            case 4:
                monedaBase = "BRL";
                monedaTarget = "USD";
                break;
            case 5:
                monedaBase = "USD";
                monedaTarget = "COP";
                break;
            case 6:
                monedaBase = "COP";
                monedaTarget = "USD";
                break;
        }

        String direccion = "https://v6.exchangerate-api.com/v6/fa51a6e96f73668198e5ec6f/pair/"+ monedaBase + "/" + monedaTarget + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response;


            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Conversion.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
