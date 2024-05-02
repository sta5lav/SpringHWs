package com.example.springhws.model;

import javax.persistence.*;

import com.example.springhws.dto.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserAllDetails.class)
    private Long id;

    private BigDecimal sum;

    private String status;

    @OneToMany
    private List<Product> products;



}
