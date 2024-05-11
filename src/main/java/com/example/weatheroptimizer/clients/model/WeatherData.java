package com.example.weatheroptimizer.clients.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record WeatherData(
        WeatherSource source,
        Temperature temperature,
        Humidity humidity,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime validTime) implements Comparable<WeatherData> {
    @Override
    public int compareTo(WeatherData data) {
        return temperature.compareTo(data.temperature());
    }
}
