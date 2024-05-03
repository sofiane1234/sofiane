package com.ynov.sofiane.repositories;

import com.ynov.sofiane.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User createUser(User user);
    List<User> findByEmail(String email);
    Optional<User> findById(User user);
    List<User> findAll();

    Optional<User> findByRole(String role);

}
