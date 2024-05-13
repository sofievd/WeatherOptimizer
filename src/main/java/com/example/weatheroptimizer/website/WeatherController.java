package com.example.weatheroptimizer.website;

import com.example.weatheroptimizer.service.WeatherAggregator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    private WeatherAggregator aggregator;


    @GetMapping("/weather/forecast")
    public String getForecast(Model model){
       model.addAttribute("forcast", aggregator.getBestForecast());
       return "weatherForecast";
    }


}
