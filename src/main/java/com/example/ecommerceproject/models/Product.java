package com.example.ecommerceproject.models;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Setter
@Getter
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private Category category;
}
