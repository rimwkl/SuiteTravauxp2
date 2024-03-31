package com.example.jpa2_app.repositories;

import com.example.jpa2_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName); //spring data
}
