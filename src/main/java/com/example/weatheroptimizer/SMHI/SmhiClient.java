package com.example.weatheroptimizer.SMHI;

import com.example.weatheroptimizer.SMHI.model.Parameter;
import com.example.weatheroptimizer.SMHI.model.Smhi;
import com.example.weatheroptimizer.SMHI.model.TimeSeries;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SmhiClient {

    private static final String ENTRY_POINT = "https://opendata-download-metfcst.smhi.se/";
    private static final String GET_DATA = "/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json";
    private WebClient webClient;

    public SmhiClient() {
        webClient = WebClient.builder()
                .baseUrl("https://opendata-download-metfcst.smhi.se/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void getSmhiData(){
        Mono<Smhi> mono = webClient
                .get()
                .uri(ENTRY_POINT + GET_DATA)
                .retrieve()
                .bodyToMono(Smhi.class);

        Smhi smhi =  mono.block();

        for (TimeSeries timeSeries: smhi.getTimeSeries()){
            System.out.print("timestamp: " + timeSeries.getValidTime());

            for (Parameter parameter : timeSeries.getParameters()) {
                if (parameter.getName().equalsIgnoreCase("t")) {
                    System.out.print("\t\ttemp: " + parameter.getValues().get(0));
                }

                if (parameter.getName().equalsIgnoreCase("r")) {
                    System.out.println("\t\thumidity: " + Math.round(parameter.getValues().get(0)));
                }
            }
        }
    }

}

