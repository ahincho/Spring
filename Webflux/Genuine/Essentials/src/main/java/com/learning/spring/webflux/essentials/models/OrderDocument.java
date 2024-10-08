package com.learning.spring.webflux.essentials.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "orders")
public class OrderDocument {
    @Id
    private String id;
    private String customerId;
    private Double totalAmount;
    private Double discount;
    public OrderDocument() {}
    public OrderDocument(String id, String customerId, Double totalAmount, Double discount) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.discount = discount;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "OrderDocument [id=" + id + ", customerId=" + customerId + ", totalAmount=" + totalAmount + ", discount=" + discount + "]";
    }
}
