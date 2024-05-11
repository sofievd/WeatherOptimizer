package com.example.weatheroptimizer.service;

import com.example.weatheroptimizer.clients.WeatherDataProvider;
import com.example.weatheroptimizer.clients.model.WeatherData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WeatherAggregator {

    private WeatherDataProvider smhiClient;
    private WeatherDataProvider dwdClient;

    public WeatherAggregator(WeatherDataProvider smhiClient, WeatherDataProvider dwdClient) {
        this.smhiClient = smhiClient;
        this.dwdClient = dwdClient;
    }

    public WeatherData getBestForecast() {
        WeatherData data1 = smhiClient.predictWeather();
        WeatherData data2 = dwdClient.predictWeather();

        List<WeatherData> dataList = new ArrayList<>();
        Collections.addAll(dataList, data1, data2);
        Collections.reverse(dataList);
        return dataList.get(0);
    }
}
