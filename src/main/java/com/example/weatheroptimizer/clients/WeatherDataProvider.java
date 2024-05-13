package com.example.weatheroptimizer.clients;

import com.example.weatheroptimizer.clients.model.WeatherData;

public interface WeatherDataProvider {

    WeatherData predictWeather();
}
