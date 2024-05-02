package com.example.springhws.model;


import com.example.springhws.dto.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserDetails.class)
    private long id;

    @JsonView(Views.UserSummary.class)
    private String name;

    @Pattern(regexp = "^(.+)@(\\\\S+)$")
    @JsonView(Views.UserSummary.class)
    private String email;


    @JoinColumn(name = "order_id")
    @OneToOne
    @JsonView(Views.UserDetails.class)
    private Order order;
}
