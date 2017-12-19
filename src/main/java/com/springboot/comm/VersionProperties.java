package com.springboot.comm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VersionProperties {

    @Value("${com.cleverly.name}")
    private String name;

    @Value("${com.cleverly.description}")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{\"VersionProperties\":{"
                + "\"name\":\"" + name + "\""
                + ",\"description\":\"" + description + "\""
                + "}}";
    }
}
