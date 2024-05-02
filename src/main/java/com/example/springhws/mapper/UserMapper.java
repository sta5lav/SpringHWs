package com.example.springhws.mapper;
import com.example.springhws.dto.UpdateUserDto;
import com.example.springhws.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    public abstract User userDtoUpdateToUserEntity(UpdateUserDto updateUserDto);


}
