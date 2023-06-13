package com.shoppingcart.api.services.impl;

import com.shoppingcart.api.entity.Product;
import com.shoppingcart.api.repositories.ProductRepository;
import com.shoppingcart.api.repositories.ShoppingCartRepository;
import com.shoppingcart.api.services.ShoppingCartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    private Map<Optional<Product>, Integer> products = new HashMap<Optional<Product>, Integer>();

    @Autowired
    public ShoppingCartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public double getTotalPrice() {
        List<Product> products = productRepository.findAll();
        int totalItens = products.stream().mapToInt(Product::getQuantity).sum();

        int quantityItemsRemovePrice = totalItens/3;

        for(int i = 0; i< quantityItemsRemovePrice; i++){
            Product cheapest = products.stream().min(Comparator.comparingDouble(Product::getPrice)).orElse(null);
            if(cheapest != null){
                products.remove(cheapest);
            }else {
                break;
            }
        }

        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
