package com.datagrandeur.gonogo.data;

public class Response {
    private String userId;

    private String trialName;

    private String goFace;

    private String noGoFace;

    private int sequenceNumber;
    private String stimulus;
    private boolean userInput;
    private String startMillis;
    private String endMillis;
    private String userInputMillis;
    private boolean correct;

    public Response(String userId, String trialName, String goFace, String noGoFace, int sequenceNumber, String stimulus, boolean userInput, String startMillis, String endMillis, String userInputMillis, boolean correct) {
        this.userId = userId;
        this.trialName = trialName;
        this.startMillis = startMillis;
        this.endMillis = endMillis;
        this.userInputMillis = userInputMillis;
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

    public String getStartMillis() {
        return startMillis;
    }

    public void setStart(String startMillis) {
        this.startMillis = startMillis;
    }

    public String getEndMillis() {
        return endMillis;
    }

    public void setEndMillis(String endMillis) {
        this.endMillis = endMillis;
    }

    public String getUserInputMillis() {
        return userInputMillis;
    }

    public void setUserInputMillis(String userInputMillis) {
        this.userInputMillis = userInputMillis;
    }

    public String getStimulus() {
        return stimulus;
    }

    public void setStimulus(String stimulus) {
        this.stimulus = stimulus;
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
