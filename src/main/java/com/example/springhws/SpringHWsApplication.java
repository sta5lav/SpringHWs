package com.example.springhws;


import com.example.springhws.model.User;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
@OpenAPIDefinition
public class SpringHWsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringHWsApplication.class, args);
    }


}
