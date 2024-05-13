package com.example.weatheroptimizer.service;

import com.example.weatheroptimizer.clients.WeatherDataProvider;
import com.example.weatheroptimizer.clients.model.Humidity;
import com.example.weatheroptimizer.clients.model.WeatherData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

        if (dataList.get(0).temperature().value() == dataList.get(1).temperature().value()) {
            return getBestHumidityFromData(data1, data2);
        } else if (dataList.get(0).temperature().value() > dataList.get(1).temperature().value()) {
            return dataList.get(0);
        } else {
            return dataList.get(1);
        }
    }

    private WeatherData getBestHumidityFromData(WeatherData data1, WeatherData data2) {
        Humidity hum1 = new Humidity(data1.humidity().value(), data1.humidity().unit());
        Humidity hum2 = new Humidity(data2.humidity().value(), data2.humidity().unit());

        if (hum1.value() > hum2.value()) {
            return data1;
        } else {
            return data2;
        }
    }
}
