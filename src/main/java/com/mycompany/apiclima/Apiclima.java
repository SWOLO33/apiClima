package com.mycompany.apiclima;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Apiclima {

    // OJO: esta clave es solo para uso local.
    // Cuando subamos el proyecto a GitHub, la vamos a mover a variable de entorno.
    private static final String API_KEY = "_AQUI_API_KEY_";
    private static final String URL_BASE = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Apiclima ===");
        System.out.print("Escribe la ciudad (ejemplo: Puebla,mx): ");
        String ciudad = sc.nextLine().trim();

        if (ciudad.isEmpty()) {
            System.out.println("No se escribio ninguna ciudad. Saliendo.");
            return;
        }

        try {
            obtenerClima(ciudad);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener el clima: " + e.getMessage());
        }
    }

    private static void obtenerClima(String ciudad)
            throws IOException, InterruptedException {

        String url = URL_BASE
                + "?q=" + ciudad
                + "&appid=" + API_KEY
                + "&units=metric"
                + "&lang=es";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> resp =
                client.send(req, HttpResponse.BodyHandlers.ofString());

        if (resp.statusCode() == 200) {

            JsonObject datos = JsonParser
                    .parseString(resp.body())
                    .getAsJsonObject();

            String nombre = datos.get("name").getAsString();

            JsonObject weather0 = datos
                    .getAsJsonArray("weather")
                    .get(0).getAsJsonObject();
            String descripcion = weather0.get("description").getAsString();

            JsonObject main = datos.getAsJsonObject("main");
            double temp = main.get("temp").getAsDouble();
            double sensacion = main.get("feels_like").getAsDouble();
            int humedad = main.get("humidity").getAsInt();

            String pais = datos
                    .getAsJsonObject("sys")
                    .get("country").getAsString();

            System.out.println("\n---- Clima Actual ----");
            System.out.printf("| Ciudad            : %s%n", nombre);
            System.out.printf("| Descripcion       : %s%n", capitalizar(descripcion));
            System.out.printf("| Temperatura       : %.1f C%n", temp);
            System.out.printf("| Sensacion termica : %.1f C%n", sensacion);
            System.out.printf("| Humedad           : %d%%%n", humedad);
            System.out.printf("| Pais              : %s%n", pais);
            System.out.println("----------------------\n");
            System.out.println("scocolot UMAD on LINE 2025\n");
            System.out.println("Prueba tu API ahora\n");

        } else {
            System.out.println("Ciudad no encontrada. Codigo HTTP: " + resp.statusCode());
        }
    }

    private static String capitalizar(String s) {
        if (s == null || s.isBlank()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
