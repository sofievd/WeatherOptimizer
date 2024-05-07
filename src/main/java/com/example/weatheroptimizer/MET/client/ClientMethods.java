package com.example.weatheroptimizer.MET.client;

import com.example.weatheroptimizer.MET.entity.Met;
import com.example.weatheroptimizer.MET.entity.Properties;
import com.example.weatheroptimizer.MET.entity.Timeseries;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class ClientMethods {
    private WebClient client = WebClient.create();

    public void getMetData(){
        Mono<Met> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(Met.class);

         Met met=  mono.block();

         for(Timeseries timeseries: met.getProperties().getTimeseries()){
             System.out.println("time: " + timeseries.getTime() +" temperature : " + timeseries.getData().getInstant().getDetails().getAirTemperature());
         }
    }




}
