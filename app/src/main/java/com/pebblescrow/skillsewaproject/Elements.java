package com.pebblescrow.skillsewaproject;

public class Elements {
    private int id;
    private byte[] image;
    private String location;
    private String inspector;
    private String DOI;
    private String HouseName;

    public Elements(int id, byte[] image, String location, String inspector, String DOI, String houseName) {
        this.id = id;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
