package com.example.weatheroptimizer.smhi;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "name",
    "owner",
    "ownerCategory",
    "measuringStations",
    "from",
    "to",
    "height",
    "latitude",
    "longitude",
    "value"
})

public class Station {

    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("ownerCategory")
    private String ownerCategory;
    @JsonProperty("measuringStations")
    private String measuringStations;
    @JsonProperty("from")
    private Long from;
    @JsonProperty("to")
    private Long to;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("value")
    private List<Value> value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @JsonProperty("ownerCategory")
    public String getOwnerCategory() {
        return ownerCategory;
    }

    @JsonProperty("ownerCategory")
    public void setOwnerCategory(String ownerCategory) {
        this.ownerCategory = ownerCategory;
    }

    @JsonProperty("measuringStations")
    public String getMeasuringStations() {
        return measuringStations;
    }

    @JsonProperty("measuringStations")
    public void setMeasuringStations(String measuringStations) {
        this.measuringStations = measuringStations;
    }

    @JsonProperty("from")
    public Long getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(Long from) {
        this.from = from;
    }

    @JsonProperty("to")
    public Long getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(Long to) {
        this.to = to;
    }

    @JsonProperty("height")
    public Double getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Double height) {
        this.height = height;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("value")
    public List<Value> getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(List<Value> value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
