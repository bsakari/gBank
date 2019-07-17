package com.demotxt.droidsrce.homedashboard;

public class Transaction {
    private String amount,key;

    public Transaction(String amount, String key) {
        this.amount = amount;
        this.key = key;
    }

    public Transaction() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
