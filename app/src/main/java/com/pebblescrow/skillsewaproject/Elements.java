package com.pebblescrow.skillsewaproject;

public class Elements {
    private int id;
    private byte[] image;
    private String location;
    private String city;
    private String inspector;
    private String DOI;
    private String HouseName;
    private byte[] image1;

    public Elements(int id, byte[] image, String location, String city, String inspector, String DOI, String houseName, byte[] image1) {
        this.id = id;
        this.image = image;
        this.location = location;
        this.city = city;
        this.inspector = inspector;
        this.DOI = DOI;
        this.HouseName = houseName;
        this.image1 = image1;
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

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        this.HouseName = houseName;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }
}
