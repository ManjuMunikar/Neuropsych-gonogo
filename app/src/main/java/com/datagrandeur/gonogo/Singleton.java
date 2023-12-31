package com.datagrandeur.gonogo;
public class Singleton {

    private int trialId;

    private String trialName;

    private static Singleton instance;

    private String userId;
    private String fullName;
    private String language = "en";
    private String location = "global";

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }


    private Singleton() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTrialId() {
        return trialId;
    }

    public void setTrialId(int trialId) {
        this.trialId = trialId;
    }


    public String getTrialName() {
        return trialName;
    }

    public void setTrialName(String trialName) {
        this.trialName = trialName;
    }
}