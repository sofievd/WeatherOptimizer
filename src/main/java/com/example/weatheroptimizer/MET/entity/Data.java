
package com.example.weatheroptimizer.MET.entity;

import java.util.LinkedHashMap;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instant",
    "next_12_hours",
    "next_1_hours",
    "next_6_hours"
})
public class Data {

    @JsonProperty("instant")
    private Instant instant;
    @JsonProperty("next_12_hours")
    private Next12Hours next12Hours;
    @JsonProperty("next_1_hours")
    private Next1Hours next1Hours;
    @JsonProperty("next_6_hours")
    private Next6Hours next6Hours;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param next12Hours
     * @param next6Hours
     * @param next1Hours
     * @param instant
     */
    public Data(Instant instant, Next12Hours next12Hours, Next1Hours next1Hours, Next6Hours next6Hours) {
        super();
        this.instant = instant;
        this.next12Hours = next12Hours;
        this.next1Hours = next1Hours;
        this.next6Hours = next6Hours;
    }

    @JsonProperty("instant")
    public Instant getInstant() {
        return instant;
    }

    @JsonProperty("instant")
    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @JsonProperty("next_12_hours")
    public Next12Hours getNext12Hours() {
        return next12Hours;
    }

    @JsonProperty("next_12_hours")
    public void setNext12Hours(Next12Hours next12Hours) {
        this.next12Hours = next12Hours;
    }

    @JsonProperty("next_1_hours")
    public Next1Hours getNext1Hours() {
        return next1Hours;
    }

    @JsonProperty("next_1_hours")
    public void setNext1Hours(Next1Hours next1Hours) {
        this.next1Hours = next1Hours;
    }

    @JsonProperty("next_6_hours")
    public Next6Hours getNext6Hours() {
        return next6Hours;
    }

    @JsonProperty("next_6_hours")
    public void setNext6Hours(Next6Hours next6Hours) {
        this.next6Hours = next6Hours;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Data{" +
                "instant=" + instant +
                ", next12Hours=" + next12Hours +
                ", next1Hours=" + next1Hours +
                ", next6Hours=" + next6Hours +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
