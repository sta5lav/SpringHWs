package com.example.springhws.service;

import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.mapper.UserMapper;
import com.example.springhws.model.User;
import com.example.springhws.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findAllById(id);
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
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
