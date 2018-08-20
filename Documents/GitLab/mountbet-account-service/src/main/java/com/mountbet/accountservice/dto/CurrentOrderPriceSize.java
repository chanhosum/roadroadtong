package com.mountbet.accountservice.dto;

import java.io.Serializable;

public class CurrentOrderPriceSize implements Serializable {
    private double price;

    private double size;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "CurrentOrderPriceSize{" +
                "price=" + price +
                ", size=" + size +
                '}';
    }
}
