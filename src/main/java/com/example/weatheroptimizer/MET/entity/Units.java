
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
    "air_pressure_at_sea_level",
    "air_temperature",
    "cloud_area_fraction",
    "precipitation_amount",
    "relative_humidity",
    "wind_from_direction",
    "wind_speed"
})
public class Units {

    @JsonProperty("air_pressure_at_sea_level")
    private String airPressureAtSeaLevel;
    @JsonProperty("air_temperature")
    private String airTemperature;
    @JsonProperty("cloud_area_fraction")
    private String cloudAreaFraction;
    @JsonProperty("precipitation_amount")
    private String precipitationAmount;
    @JsonProperty("relative_humidity")
    private String relativeHumidity;
    @JsonProperty("wind_from_direction")
    private String windFromDirection;
    @JsonProperty("wind_speed")
    private String windSpeed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Units() {
    }

    /**
     * 
     * @param airTemperature
     * @param relativeHumidity
     * @param windFromDirection
     * @param precipitationAmount
     * @param airPressureAtSeaLevel
     * @param windSpeed
     * @param cloudAreaFraction
     */
    public Units(String airPressureAtSeaLevel, String airTemperature, String cloudAreaFraction, String precipitationAmount, String relativeHumidity, String windFromDirection, String windSpeed) {
        super();
        this.airPressureAtSeaLevel = airPressureAtSeaLevel;
        this.airTemperature = airTemperature;
        this.cloudAreaFraction = cloudAreaFraction;
        this.precipitationAmount = precipitationAmount;
        this.relativeHumidity = relativeHumidity;
        this.windFromDirection = windFromDirection;
        this.windSpeed = windSpeed;
    }

    @JsonProperty("air_pressure_at_sea_level")
    public String getAirPressureAtSeaLevel() {
        return airPressureAtSeaLevel;
    }

    @JsonProperty("air_pressure_at_sea_level")
    public void setAirPressureAtSeaLevel(String airPressureAtSeaLevel) {
        this.airPressureAtSeaLevel = airPressureAtSeaLevel;
    }

    @JsonProperty("air_temperature")
    public String getAirTemperature() {
        return airTemperature;
    }

    @JsonProperty("air_temperature")
    public void setAirTemperature(String airTemperature) {
        this.airTemperature = airTemperature;
    }

    @JsonProperty("cloud_area_fraction")
    public String getCloudAreaFraction() {
        return cloudAreaFraction;
    }

    @JsonProperty("cloud_area_fraction")
    public void setCloudAreaFraction(String cloudAreaFraction) {
        this.cloudAreaFraction = cloudAreaFraction;
    }

    @JsonProperty("precipitation_amount")
    public String getPrecipitationAmount() {
        return precipitationAmount;
    }

    @JsonProperty("precipitation_amount")
    public void setPrecipitationAmount(String precipitationAmount) {
        this.precipitationAmount = precipitationAmount;
    }

    @JsonProperty("relative_humidity")
    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    @JsonProperty("relative_humidity")
    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @JsonProperty("wind_from_direction")
    public String getWindFromDirection() {
        return windFromDirection;
    }

    @JsonProperty("wind_from_direction")
    public void setWindFromDirection(String windFromDirection) {
        this.windFromDirection = windFromDirection;
    }

    @JsonProperty("wind_speed")
    public String getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_speed")
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
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
