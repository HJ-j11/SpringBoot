package com.example.hellospring.repository;

import com.example.hellospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findUserById(String id);

    User findByUsername(String username);
}
