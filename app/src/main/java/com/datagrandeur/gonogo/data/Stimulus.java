package com.datagrandeur.gonogo.data;

public class Stimulus {

    private int id;
    private String filename;
    private String category;
    private String location;

    public Stimulus(int id, String filename, String category, String location){
        this.id = id;
        this.filename = filename;
        this.category = category;
        this.location = location;
    }

    public Stimulus(String filename, String category, String location){
        this.filename = filename;
        this.category = category;
        this.location = location;
    }

    public Stimulus(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setName(String filename) {
        this.filename = filename;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}