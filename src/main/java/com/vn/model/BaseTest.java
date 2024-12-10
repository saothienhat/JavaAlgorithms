package com.vn.model;

public abstract class BaseTest {
    private String url;
    private String description;
    private String level;

    public BaseTest(String url, String description, String level) {
        this.url = url;
        this.description = description;
        this.level = level;
    }

    public abstract void run();

    public void info(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void error(String msg) {
        System.err.println("[ERROR] " + msg);
    }

    public void about() {
        info("Test info:");
        info("  URL: " + url);
        info("  Description: " + description);
        info("  Level: " + level);
        System.out.println("\n");
    }
}
