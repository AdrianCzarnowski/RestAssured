package model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentModel {

    public boolean active;
    Map<String, Object> properties = new HashMap<>();

    public boolean isActive() {
        return active;
    }

    @JsonAnySetter
    void setEnvironmentProperties(String key, Object value) {
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getEnvironmentProperties() {
        return properties;
    }

}
