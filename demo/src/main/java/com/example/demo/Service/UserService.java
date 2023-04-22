package com.example.demo.Service;

import com.example.demo.controllers.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.User_type;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    User findByUserame(String name);
    List<User> findByType(User_type user_type);
    List<User> findAll();
    User insertUser(User user);

    @SneakyThrows
    User updateUser(UserDTO userDTO, String password);
}
