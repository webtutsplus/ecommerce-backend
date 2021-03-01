package com.webtutsplus.ecommerce.model;

public class CheckoutBody {

    private long price;
    private long quantity;
    private String productName;
    private long productId;

    public CheckoutBody(long price, long quantity, String productName, long productId) {
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
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
