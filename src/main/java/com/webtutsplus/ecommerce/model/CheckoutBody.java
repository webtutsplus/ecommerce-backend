package com.webtutsplus.ecommerce.model;

public class CheckoutBody {

    private long price;
    private long quantity;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public CheckoutBody(long price, long quantity, String productName) {
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
