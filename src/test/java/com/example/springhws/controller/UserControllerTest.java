package com.example.springhws.controller;


import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.dto.Views;
import com.example.springhws.model.User;
import com.example.springhws.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetUser() {
        Long userId = 1L;
        User expectedUser = new User();
        when(userService.getUser(userId)).thenReturn(expectedUser);
        User actualUser = userController.getUser(userId);
        assertEquals(expectedUser, actualUser);
        verify(userService, times(1)).getUser(userId);
    }

    @Test
    public void testGetAllUsers() {
        List<User> expectedUserList = List.of(new User(), new User());
        when(userService.getAllUsers()).thenReturn(expectedUserList);
        List<User> actualUserList = userController.getAllUsers();
        assertEquals(expectedUserList, actualUserList);
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void whenGetAllUsersViewToSerialize() throws IOException {
        final List<User> expectedUserList = List.of(new User());
        when(userService.getAllUsers()).thenReturn(expectedUserList);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        String result = mapper
                    .writerWithView(Views.UserSummary.class)
                    .writeValueAsString(userController.getAllUsers().get(0));
        assertFalse(result.contains("id"));
        assertFalse(result.contains("product"));

    }

    @Test
    public void testCreateUser() {
        User user = new User();
        when(userService.createUser(user)).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.createUser(user);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    public void testUpdateUser() {
        UpdateUserDto updateUserDto = new UpdateUserDto();
        when(userService.updateUser(updateUserDto)).thenReturn(true);
        ResponseEntity<Void> responseEntity = userController.updateUser(updateUserDto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userService, times(1)).updateUser(updateUserDto);
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        when(userService.delete(userId)).thenReturn(true);
        ResponseEntity<Void> responseEntity = userController.deleteUser(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userService, times(1)).delete(userId);
    }




}
