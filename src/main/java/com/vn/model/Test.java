package com.vn.model;

import com.vn.utils.AppLogger;

public class Test {
    private String name;
    private String level;
    private String description;
    private String url;


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        AppLogger.info("Test Info: ");
        AppLogger.info("Name: " + name);
        AppLogger.info("Level: " + level);
        AppLogger.info("Description: " + description);
        AppLogger.info("URL: " + url);
    }
}
