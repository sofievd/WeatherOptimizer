package com.example.weatheroptimizer.MET.client;

import com.example.weatheroptimizer.MET.entity.Met;
import com.example.weatheroptimizer.MET.entity.Timeseries;
import com.example.weatheroptimizer.util.ClientHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ClientMethods {
    private WebClient client = WebClient.create();

    public Met getMetData(){
        Mono<Met> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(Met.class);

         return mono.block();

    }
    public void getTime(Met metData){
       List<Timeseries> timeseries =  metData.getProperties().getTimeseries();

       for(Timeseries t: timeseries){
           if(ClientHelper.checkTimeInRange(t.getTime()) ){
               System.out.println("temp: " + t.getData().getInstant().getDetails().getAirTemperature() +" " + metData.getProperties().getMeta().getUnits().getAirTemperature()
               + " at time: " + t.getTime());
           }
       }

    }




}
