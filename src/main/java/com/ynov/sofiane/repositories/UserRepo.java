package com.ynov.sofiane.repositories;

import com.ynov.sofiane.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByFullname(String fullname);
    Optional<User> findByEmail(String email);
    User save(User user);
    List<User> findAll();
}
