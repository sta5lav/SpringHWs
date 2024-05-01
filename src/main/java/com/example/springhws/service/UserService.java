package com.example.springhws.service;

import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.dto.UserDto;

import java.util.List;

public interface UserService {


    UserDto getUser(Long id);

    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    boolean updateUser(UpdateUserDto updateUserDto);

    boolean delete(Long userId);
}
