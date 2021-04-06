package com.pebblescrow.skillsewaproject;

public class Elements {
    private int id;
    private byte[] image;
    private String location;
    private String city;
    private String inspector;
    private String DOI;

    public Elements(int id, byte[] image, String location, String city, String inspector, String DOI) {
        this.id = id;
        this.image = image;
        this.location = location;
        this.city = city;
        this.inspector = inspector;
        this.DOI = DOI;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
}
