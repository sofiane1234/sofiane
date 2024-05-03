package com.ynov.sofiane.repositories;

import com.ynov.sofiane.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    UserRepo extends JpaRepository<User, Long> {
    User save(User user);
    List<User> findAll();
}
