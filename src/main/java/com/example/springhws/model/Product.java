package com.example.springhws.model;


import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;
    private BigDecimal sum;
}
