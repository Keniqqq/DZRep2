package ru.netology;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CatsFactApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats ";

        // 1. Создаем HTTP клиент
        HttpClient client = HttpClient.newHttpClient();

        // 2. Формируем запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // 3. Выполняем запрос
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String json = response.body();

            // 4. Парсим JSON в список объектов
            ObjectMapper mapper = new ObjectMapper();
            CatFact[] factsArray = mapper.readValue(json, CatFact[].class);
            List<CatFact> factsList = Arrays.asList(factsArray);

            // 5. Фильтруем: только с голосами
            List<CatFact> filteredFacts = factsList.stream()
                    .filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0)
                    .collect(Collectors.toList());

            // 6. Выводим результат
            System.out.println("Факты с голосами:");
            filteredFacts.forEach(System.out::println);
        } else {
            System.err.println("Ошибка загрузки данных. Код ответа: " + response.statusCode());
        }
    }
}