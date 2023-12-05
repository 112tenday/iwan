package com.phincon.bootcamp.agung.model;

public class Account {
    int id;
    String name;
    double amount;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    // public String getIdString() {
    // return String.valueOf(this.id);
    // }
}
