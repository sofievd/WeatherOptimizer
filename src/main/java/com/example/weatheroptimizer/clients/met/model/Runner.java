package com.example.weatheroptimizer.clients.met.model;

import com.example.weatheroptimizer.service.WeatherAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner  implements CommandLineRunner {
    @Autowired
    WeatherAggregator aggregator;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(aggregator.getBestForecast());
    }
}
