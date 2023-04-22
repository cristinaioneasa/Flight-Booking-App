package com.example.demo.controllers.mapper;

import com.example.demo.controllers.DTO.UserDTO;
import com.example.demo.entity.User;

public class UserMapper {

    public static UserDTO mapModelToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setType(user.getType());

        return userDTO;
    }

    public static User mapDTOToModel(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setType(userDTO.getType());

        return user;
    }
}
