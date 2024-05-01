package com.example.springhws.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateUserDto {

    @NotNull
    private Long id;
    @NotNull
    @Size(min = 3, max = 10)
    private String name;

    @Pattern(message = "${validatedValue}",
            regexp = "^(.+)@(\\\\S+)$")
    private String email;

}
