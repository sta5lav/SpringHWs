package com.example.springhws.service;

import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.model.User;

import java.util.List;

public interface UserService {


    User getUser(Long id);

    List<User> getAllUsers();

    User createUser(User user);

    boolean updateUser(UpdateUserDto updateUserDto);

    boolean delete(Long userId);
}
