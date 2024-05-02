package com.example.springhws.controller;


import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.dto.Views;
import com.example.springhws.model.User;
import com.example.springhws.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @Operation(
            summary = "Получения информации о конкретном пользователе (включая детали заказов)",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Найденный клиент",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Клиент отсутствует в базе данных"
                    )},
            tags = "Сервис для работы с клиентами"
    )
    @GetMapping(value = "/{id}")
    @JsonView(Views.UserDetails.class)
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @Operation(
            summary = "Получения списка всех пользователей (без деталей заказов)",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Найденные клиенты",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Клиентская база пуста"
                    )},
            tags = "Сервис для работы с клиентами"
    )
    @GetMapping
    @JsonView(Views.UserSummary.class)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @Operation(
            summary = "Создания нового пользователя",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Созданный пользователь",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            ),
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Созданный пользователь",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )},
            tags = "Сервис для работы с клиентами"
    )
    @JsonView(Views.UserSummary.class)
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  @Valid @JsonView(Views.UserSummary.class) User user) {
        return ResponseEntity.ok(userService.createUser(user));

    }

    @Operation(
            summary = "Обновления информации о пользователе",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Редактируемый клиент",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            ),
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Редактируемый клиент",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )},
            tags = "Сервис для работы с клиентами"
    )
    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UpdateUserDto updateUserDto){
        return ResponseEntity.status(
                userService.updateUser(updateUserDto) ?
                        HttpStatus.OK :
                        HttpStatus.UNAUTHORIZED).build();
    }



    @Operation(
            summary = "Удаления пользователя",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Удаляемый клиент",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )

            ),

            tags = "Сервис для работы с клиентами"
    )
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId){
        return ResponseEntity.status(
                userService.delete(userId) ?
                        HttpStatus.OK :
                        HttpStatus.UNAUTHORIZED).build();
    }


}
