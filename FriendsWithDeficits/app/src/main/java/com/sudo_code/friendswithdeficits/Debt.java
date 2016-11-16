package com.sudo_code.friendswithdeficits;


import java.util.Date;

public class Debt {
    private double amount;
    private String description;
    private Date date;

    public Debt(double amount, String description, Date date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public void updateDebt(double amount, String description, Date date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
}
