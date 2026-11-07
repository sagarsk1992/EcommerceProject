package com.example.ecommerceproject.infaces;

import com.example.ecommerceproject.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();
}
