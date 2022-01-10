package com.example.springdcserviceapp;

public class Repair {
    private String id;
    private String name;
    private double price;

    public Repair(String name, double price) {

        this.name = name;
        this.price = price;
    }
    public Repair(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
