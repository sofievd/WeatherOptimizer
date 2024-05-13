package com.example.weatheroptimizer.api;

import com.example.weatheroptimizer.clients.model.WeatherData;
import com.example.weatheroptimizer.service.WeatherAggregator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RestWeatherController {

    private WeatherAggregator aggregator;

    public RestWeatherController(WeatherAggregator aggregator) {
        this.aggregator = aggregator;
    }

    @GetMapping("/weather/forecast")
    public WeatherData getForecast() {
        return aggregator.getBestForecast();
    }
}
