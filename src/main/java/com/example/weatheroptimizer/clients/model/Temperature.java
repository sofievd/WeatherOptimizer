package com.example.weatheroptimizer.clients.model;

public record Temperature(Double value, String unit) implements Comparable<Temperature> {
    @Override
    public int compareTo(Temperature temp) {
        return value.compareTo(temp.value());
    }
}
