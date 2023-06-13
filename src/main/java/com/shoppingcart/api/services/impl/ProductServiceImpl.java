package com.shoppingcart.api.services.impl;

import com.shoppingcart.api.entity.Product;
import com.shoppingcart.api.repositories.ProductRepository;
import com.shoppingcart.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteProductById(long productId) {

    }
}
