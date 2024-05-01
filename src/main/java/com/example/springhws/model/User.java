package com.example.springhws.model;


import com.example.springhws.dto.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class User {

    @JsonView(Views.UserSummary.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;


    @JoinColumn(name = "order_id")
    @OneToOne
    private Order order;
}
