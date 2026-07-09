package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Jdk26Poc {

    static void main() throws Exception {

        primitivePatterns();
        http3Client();

    }

    static void primitivePatterns() {
        System.out.println("1. Primitive Patterns + instanceof/switch:");
        Object value = 42;

        switch (value) {
            case int i when i > 0 -> System.out.println("  Positive int: " + i);
            case double d -> System.out.println("  Double: " + d);
            default -> System.out.println("  Other");
        }

        if (value instanceof int i) {
            System.out.println("  instanceof primitive: " + i);
        }
        System.out.println();
    }

    static void http3Client() throws Exception {
        System.out.println("2. HTTP/3 HttpClient:");
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("  HTTP Response: " + response.statusCode() + " (HTTP/3 capable in JDK 26)");
        } catch (Exception e) {
            System.out.println("  HTTP demo (network may vary): " + e.getMessage().substring(0, 50));
        }
        System.out.println();
    }
}