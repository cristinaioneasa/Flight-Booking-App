package com.example.demo.Repository;

import com.example.demo.entity.User;
import com.example.demo.entity.User_type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    List<User> findByType(User_type user_type);
}
