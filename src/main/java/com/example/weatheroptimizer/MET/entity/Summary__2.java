
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
    "symbol_code"
})
public class Summary__2 {

    @JsonProperty("symbol_code")
    private String symbolCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Summary__2() {
    }

    /**
     * 
     * @param symbolCode
     */
    public Summary__2(String symbolCode) {
        super();
        this.symbolCode = symbolCode;
    }

    @JsonProperty("symbol_code")
    public String getSymbolCode() {
        return symbolCode;
    }

    @JsonProperty("symbol_code")
    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
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
