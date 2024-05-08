package com.example.weatheroptimizer.SMHI;

import com.example.weatheroptimizer.SMHI.model.Parameter;
import com.example.weatheroptimizer.SMHI.model.Smhi;
import com.example.weatheroptimizer.SMHI.model.TimeSeries;
import com.example.weatheroptimizer.util.ClientHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class SmhiClient {

    private static final String ENTRY_POINT = "https://opendata-download-metfcst.smhi.se/";
    private static final String GET_DATA = "/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json";
    private WebClient webClient;

    public SmhiClient() {
        webClient = WebClient.builder()
                .baseUrl(ENTRY_POINT)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Smhi getSmhiData() {
        Mono<Smhi> mono = webClient
                .get()
                .uri(GET_DATA)
                .retrieve()
                .bodyToMono(Smhi.class);

        return mono.block();
    }

    public Optional<TimeSeries> getTimeSeriesFromSmhi(Smhi smhi) {
        for (TimeSeries t : smhi.getTimeSeries()) {
            if (ClientHelper.checkTimeInRange(t.getValidTime())) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public Double getTemperature(TimeSeries timeSeries) {
        for (Parameter parameter : timeSeries.getParameters()) {
            if (parameter.getName().equalsIgnoreCase("t")) {
                return parameter.getValues().get(0);
            }
        }
        return 0.0;
    }

    public Integer getHumidity(TimeSeries timeSeries) {
        for (Parameter parameter : timeSeries.getParameters()) {
            if (parameter.getName().equalsIgnoreCase("r")) {
                return Math.toIntExact(Math.round(parameter.getValues().get(0)));
            }
        }
        return 0;
    }

}

