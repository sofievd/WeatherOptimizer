
package com.example.weatheroptimizer.clients.met.entity;

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
    "summary",
    "details"
})
public class Next6Hours {

    @JsonProperty("summary")
    private Summary__2 summary;
    @JsonProperty("details")
    private Details__3 details;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Next6Hours() {
    }

    /**
     * 
     * @param summary
     * @param details
     */
    public Next6Hours(Summary__2 summary, Details__3 details) {
        super();
        this.summary = summary;
        this.details = details;
    }

    @JsonProperty("summary")
    public Summary__2 getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary__2 summary) {
        this.summary = summary;
    }

    @JsonProperty("details")
    public Details__3 getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details__3 details) {
        this.details = details;
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
        return "Next6Hours{" +
                "summary=" + summary +
                ", details=" + details +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
