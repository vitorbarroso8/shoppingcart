package com.shoppingcart.api.controllers;

import com.shoppingcart.api.entity.Product;
import com.shoppingcart.api.services.ShoppingCartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<List<Product>> getShoppingCart(){
        return ResponseEntity.ok(this.shoppingCartService.listAllProducts());
    }

    @Transactional
    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(shoppingCartService.addProduct(product));
    }

    @Transactional
    @DeleteMapping("/product/{id}")
    public void removeProductById(@PathVariable Long id){
        shoppingCartService.removeProduct(id);
    }

    @GetMapping("/checkout")
    public Double getCheckoutShoppingCart(){
        return shoppingCartService.getTotalPrice();
    }









}
