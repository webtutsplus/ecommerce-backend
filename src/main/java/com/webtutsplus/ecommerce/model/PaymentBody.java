package com.webtutsplus.ecommerce.model;

public class PaymentBody {

    private double amount;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PaymentBody(long amount, String token) {
        this.amount = amount;
        this.token = token;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentBody(long amount) {
        this.amount = amount;
    }
}
