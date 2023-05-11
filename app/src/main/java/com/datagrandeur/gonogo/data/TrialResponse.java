package com.datagrandeur.gonogo.data;

public class TrialResponse {
    private int id;
    private String userId;
    private String image;
    private boolean correct;
    private String response;

    private String responseTime;
    private  String response_outcome;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponse_outcome() {
        return response_outcome;
    }

    public void setResponse_outcome(String response_outcome) {
        this.response_outcome = response_outcome;
    }

    public TrialResponse(int id, String userId, String image, boolean correct, String response, String responseTime, String response_outcome) {
        this.id = id;
        this.userId = userId;
        this.image = image;
        this.correct = correct;
        this.response = response;
        this.responseTime = responseTime;
        this.response_outcome = response_outcome;
    }






}
