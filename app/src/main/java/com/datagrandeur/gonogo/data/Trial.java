package com.datagrandeur.gonogo.data;

public class Trial {

    private int id;
    private String trialName;

    private String trialCode;
    private String goFace;
    private String noGoFace;
    private int goFaceCount;
    private int noGoFaceCount;

    public Trial(int id, String trialName, String trialCode,String goFace, String noGoFace, int goFaceCount, int noGoFaceCount) {
        this.id = id;
        this.trialName = trialName;
        this.trialCode = trialCode;
        this.goFace = goFace;
        this.noGoFace = noGoFace;
        this.goFaceCount = goFaceCount;
        this.noGoFaceCount = noGoFaceCount;
    }




    public int getNoGoFaceCount() {
        return noGoFaceCount;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setTrialCode(String trialCode) {
        this.trialCode = trialCode;
    }

    public void setTrialName(String trialName) {
        this.trialName = trialName;
    }

    public void setGoFace(String goFace) {
        this.goFace = goFace;
    }

    public void setNoGoFace(String noGoFace) {
        this.noGoFace = noGoFace;
    }

    public void setGoFaceCount(int goFaceCount) {
        this.goFaceCount = goFaceCount;
    }
    public int getId() {
        return id;
    }

    public String getTrialName() {
        return trialName;
    }

    public String getTrialCode() {
        return trialCode;
    }

    public String getGoFace() {
        return goFace;
    }

    public String getNoGoFace() {
        return noGoFace;
    }

    public int getGoFaceCount() {
        return goFaceCount;
    }

    public void setNoGoFaceCount(int noGoFaceCount) {
        this.noGoFaceCount = noGoFaceCount;
    }



}
