package com.example.weatheroptimizer.met.model;

import com.example.weatheroptimizer.met.client.ClientMethods;
import com.example.weatheroptimizer.met.entity.Met;
import com.example.weatheroptimizer.smhi.SmhiClient;
import com.example.weatheroptimizer.forecast.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner  implements CommandLineRunner {
    @Autowired
    ClientMethods client;

    @Autowired
    SmhiClient smhiClient;

    @Override
    public void run(String... args) throws Exception {

        Met met = client.getMetData();
        client.getTime(met);

        WeatherData smhi = smhiClient.predictWeather();
        System.out.println(smhi);
    }
}
