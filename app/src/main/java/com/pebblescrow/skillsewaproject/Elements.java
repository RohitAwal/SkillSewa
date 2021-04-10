package com.pebblescrow.skillsewaproject;

public class Elements {
    private int id;
    private String encodedBase64Image;
    private String location;
    private String inspector;
    private String DOI;
    private String HouseName;

    public Elements(int id, String encodedBase64Image, String location, String inspector, String DOI, String houseName) {
        this.id = id;
        this.encodedBase64Image = encodedBase64Image;
        this.location = location;
        this.inspector = inspector;
        this.DOI = DOI;
        HouseName = houseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEncodedBase64Image() {
        return encodedBase64Image;
    }

    public void setEncodedBase64Image(String encodedBase64Image) {
        this.encodedBase64Image = encodedBase64Image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        HouseName = houseName;
    }
}
