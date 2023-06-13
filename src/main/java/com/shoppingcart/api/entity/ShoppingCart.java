package com.shoppingcart.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shoppingcart")
public class ShoppingCart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customerId = 1;

    @Transient
    private Double totalPrice;

    @Transient
    private int totalItems;


}
