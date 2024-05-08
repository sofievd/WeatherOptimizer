package com.example.weatheroptimizer.MET.model;

import com.example.weatheroptimizer.MET.client.ClientMethods;
import com.example.weatheroptimizer.SMHI.SmhiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    ClientMethods client;

    @Autowired
    SmhiClient smhiClient;

    @Override
    public void run(String... args) throws Exception {

        client.getMetData();
        smhiClient.getSmhiData();
    }
}
