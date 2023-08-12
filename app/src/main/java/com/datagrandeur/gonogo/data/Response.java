package com.datagrandeur.gonogo.data;

public class Response {
    private String userId;

    private String trialName;

    private String goFace;

    private String noGoFace;

    private int sequenceNumber;
    private String category;
    private String stimulus;
    private String position;
    private boolean userInput;
    private String start;
    private String end;
    private String responseTime;
    private boolean correct;

    public Response(String userId, String trialName, String goFace, String noGoFace, int sequenceNumber, String stimulus, boolean userInput, String start, String end, String responseTime, boolean correct) {
        this.userId = userId;
        this.trialName = trialName;
        this.start = start;
        this.end = end;
        this.responseTime = responseTime;
        this.noGoFace = noGoFace;
        this.goFace = goFace;
        this.sequenceNumber = sequenceNumber;
        this.userInput = userInput;
        this.correct = correct;
        this.stimulus= stimulus;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getStimulus() {
        return stimulus;
    }

    public void setStimulus(String stimulus) {
        this.stimulus = stimulus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }




    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGoFace() {
        return goFace;
    }

    public void setGoFace(String goFace) {
        this.goFace = goFace;
    }

    public String getNoGoFace() {
        return noGoFace;
    }

    public void setNoGoFace(String noGoFace) {
        this.noGoFace = noGoFace;
    }

    public String getTrialName() {
        return trialName;
    }

    public void setTrialName(String trialName) {
        this.trialName = trialName;
    }

    public boolean isUserInput() {
        return userInput;
    }

    public void setUserInput(boolean userInput) {
        this.userInput = userInput;
    }
}
