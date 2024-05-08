package com.example.weatheroptimizer.MET.model;

import com.example.weatheroptimizer.MET.client.ClientMethods;
import com.example.weatheroptimizer.MET.entity.Met;
import com.example.weatheroptimizer.SMHI.SmhiClient;
import com.example.weatheroptimizer.SMHI.model.Smhi;
import com.example.weatheroptimizer.SMHI.model.TimeSeries;
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

        Smhi smhi = smhiClient.getSmhiData();
        TimeSeries t = smhiClient.getTimeSeriesFromSmhi(smhi).get();
        System.out.println("---------------- From SMHI ------------------ ");
        System.out.println("Timestamp: " + t.getValidTime());
        System.out.println("Temp: " + smhiClient.getTemperature(t));
        System.out.println("Humidity: " + smhiClient.getHumidity(t));
    }
}
