package com.pebblescrow.skillsewaproject;

public class Elements {
    private int id;
    private String frontImageEncodedInBase64;
    private String backImageEncodedInBase64;
    private String PDImageEncodedInBase64;
    private String location;
    private String inspector;
    private String DOI;
    private String houseName;

    public Elements(int id, String frontImageEncodedInBase64, String backImageEncodedInBase64, String PDImageEncodedInBase64, String location, String inspector, String DOI, String houseName) {
        this.id = id;
        this.frontImageEncodedInBase64 = frontImageEncodedInBase64;
        this.backImageEncodedInBase64 = backImageEncodedInBase64;
        this.PDImageEncodedInBase64 = PDImageEncodedInBase64;
        this.location = location;
        this.inspector = inspector;
        this.DOI = DOI;
        this.houseName = houseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrontImageEncodedInBase64() {
        return frontImageEncodedInBase64;
    }

    public void setFrontImageEncodedInBase64(String frontImageEncodedInBase64) {
        this.frontImageEncodedInBase64 = frontImageEncodedInBase64;
    }

    public String getBackImageEncodedInBase64() {
        return backImageEncodedInBase64;
    }

    public void setBackImageEncodedInBase64(String backImageEncodedInBase64) {
        this.backImageEncodedInBase64 = backImageEncodedInBase64;
    }

    public String getPDImageEncodedInBase64() {
        return PDImageEncodedInBase64;
    }

    public void setPDImageEncodedInBase64(String PDImageEncodedInBase64) {
        this.PDImageEncodedInBase64 = PDImageEncodedInBase64;
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
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
