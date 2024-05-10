package com.example.weatheroptimizer.forecast;

import com.example.weatheroptimizer.forecast.model.WeatherData;

public interface WeatherDataProvider {

    WeatherData predictWeather();
}
