package com.spring.players;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DownloadCourses {
    public static void main(String[] args) {
        try {
            // الاتصال بـ API
            URL url = new URL("https://new.gammal.tech/api/products_all");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder jsonResponse = new StringBuilder();
                while (scanner.hasNext()) {
                    jsonResponse.append(scanner.nextLine());
                }
                scanner.close();

                // تحليل JSON باستخدام Jackson
                ObjectMapper mapper = new ObjectMapper();
                JsonNode products = mapper.readTree(jsonResponse.toString());

                for (JsonNode product : products) {
                    if (product.has("name") && product.get("name").asText().contains("C")) {
                        System.out.println("Course: " + product.get("name").asText());
                    }
                }
            } else {
                System.out.println("Failed to connect. Response Code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




