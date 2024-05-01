package com.example.springhws.service;

import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.dto.UserDto;
import com.example.springhws.mapper.UserMapper;
import com.example.springhws.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userMapper.listUserEntityToListUserDto(userRepository.findAll());
    }

    public UserDto getUser(Long id) {
        return userMapper.userEntityToUserDto(userRepository.findAllById(id));
    }

    public UserDto createUser(UserDto userDto) {
        userRepository.save(userMapper.userDtoToUserEntity(userDto));
        return userDto;
    }

    public boolean updateUser(UpdateUserDto updateUserDto) {
        if (userRepository.existsById(updateUserDto.getId())) {
            userRepository.save(userMapper.userDtoUpdateToUserEntity(updateUserDto));
            return true;
        }
        return false;
    }

    public boolean delete(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
