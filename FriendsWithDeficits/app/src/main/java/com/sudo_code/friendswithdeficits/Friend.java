package com.sudo_code.friendswithdeficits;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Friend {
    private String name;
    private List<Debt> debtList;

    public Friend(String name) {
        debtList = new ArrayList<>();
        this.name = name;
    }

    public void addDebt(double amount, String description, Date date) {
        debtList.add(new Debt(amount, description, date));
    }

    public void removeDebt(Debt debt) {
        debtList.remove(debt);
    }

    public double getOwing() {
        double owed = 0.00;
        for (Debt debt : debtList) {
            owed += debt.getAmount();
        }
        return owed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
