package com.example.weatheroptimizer.forecast.model;

import java.time.LocalDateTime;

public record WeatherData(
        WeatherSource source,
        Temperature temperature,
        Humidity humidity,
        LocalDateTime validTime) {
}
