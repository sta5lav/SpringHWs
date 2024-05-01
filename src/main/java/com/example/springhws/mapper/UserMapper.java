package com.example.springhws.mapper;
import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.dto.UserDto;
import com.example.springhws.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract User userDtoToUserEntity(UserDto userDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    public abstract User userDtoUpdateToUserEntity(UpdateUserDto updateUserDto);

    public abstract UserDto userEntityToUserDto(User user);


    public abstract List<UserDto> listUserEntityToListUserDto(List<User> user);

}
