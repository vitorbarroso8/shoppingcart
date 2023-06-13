package com.shoppingcart.api.services;

import com.shoppingcart.api.entity.Product;

import java.util.List;

public interface ShoppingCartService {

    Product addProduct(Product product);

    void removeProduct(Long productId);

    List<Product> listAllProducts();

    double getTotalPrice();
}
