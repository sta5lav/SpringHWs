package com.example.springhws.model;


import javax.persistence.*;

import com.example.springhws.dto.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserAllDetails.class)
    private Long id;

    private String nameProduct;
    private BigDecimal sum;
}
