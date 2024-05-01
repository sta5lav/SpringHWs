package com.example.springhws.dto;

import com.example.springhws.model.Order;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
public class UserDto {

    @JsonView(Views.UserDetails.class)
    private long id;

    @NotNull
    @Size(min = 3, max = 10)
    private String name;

    @Pattern(message = "${validatedValue}",
            regexp = "^(.+)@(\\\\S+)$")
    private String email;

    @JsonView(Views.UserDetails.class)
    private Order order;

}
