package com.pluralsight.model;

public class Shipper {
    private int id;
    private String name;
    private String phone;

    public Shipper(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String shipperString() {
        return String.format("| %-5d | %-30s | %-20s |%n", id, name, phone);
    }
}