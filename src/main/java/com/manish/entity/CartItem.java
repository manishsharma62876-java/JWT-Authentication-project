package com.manish.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    // User Reference
    @Column(nullable = false)
    private String userEmail;

    // Product Reference
    @Column(nullable = false)
    private Integer productId;

    private String productName;

    private Double price;

    private Integer quantity;

    private Double totalPrice;
}