package com.shoppingcart.api.services;

import com.shoppingcart.api.entity.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    public void deleteProductById(long productId);




}
