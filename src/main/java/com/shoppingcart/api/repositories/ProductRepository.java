package com.shoppingcart.api.repositories;

import com.shoppingcart.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
