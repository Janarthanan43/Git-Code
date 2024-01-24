package com.example.mobilephonedemo;

public class Mobile {
    private String model;
    private String version;

    public Mobile(String model, String version) {
        this.model = model;
        this.version = version;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public void updateSoftware(String newVersion) {
        System.out.println("Updating software...");
        this.version = newVersion;
        System.out.println("Software update complete. Current version: " + this.version);
    }
}
