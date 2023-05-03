package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.controllers.DTO.UserDTO;
import com.example.demo.controllers.mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.User_type;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImplementare implements UserService{

    @Autowired
    private UserRepository userRepository;
        public UserServiceImplementare(UserRepository userRepository){
            this.userRepository = userRepository;
        }

    @Override
    public UserDTO findByEmail(String username) {
        return UserMapper.mapModelToDTO(userRepository.findByEmail(username));
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User insertUser(User user) {
        if(user.getEmail()== null || user.getPassword()== null || user.getName()== null)
        {
            throw new IllegalStateException("Email or password or name is null");
        }
        if (userRepository.findByEmail(user.getEmail()) != null)
        {
            throw new IllegalStateException("Email already used!");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(String email, String old_password, String new_password){
            UserDTO user = findByEmail(email);
            if(user.getPassword().equals(old_password)) {
                System.out.println("old_password" + old_password);
                user.setPassword(new_password);
            }
            System.out.println("parola setata " + user.getPassword());
            userRepository.save(UserMapper.mapDTOToModel(user));
            return UserMapper.mapDTOToModel(user);
    }

    @Override
    public List<UserDTO> findBylogInOrNot() {
        List<User> users = (List<User>) userRepository.findAllByLogged(true);
        return users.stream().map(UserMapper::mapModelToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO loginUser(String username, String password) {
        User user = userRepository.findByEmail(username);

        if (user != null) {
            if(user.getType() == User_type.CLIENT) {
                if (user.getPassword().equals(password)) {
                    user.setLogged(true);
                    userRepository.save(user);
                    return UserMapper.mapModelToDTO(user);
                }
            }
        }
        return null;
    }

    @Override
    public UserDTO logOut(String email) {
        User user = userRepository.findByEmail(email);
        user.setLogged(false);
        userRepository.save(user);
        return UserMapper.mapModelToDTO(user);
    }

    @Override
    public UserDTO loginAdmin(String username, String password) {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            if(user.getType() == User_type.ADMIN) {
                if (user.getPassword().equals(password)) {
                    return UserMapper.mapModelToDTO(user);
                }
            }
        }
        return null;
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(UserMapper::mapModelToDTO).collect(Collectors.toList());
    }

    public String forgotPassword(String email){
            User user = userRepository.findByEmail(email);
            return user.getPassword();
    }
}
