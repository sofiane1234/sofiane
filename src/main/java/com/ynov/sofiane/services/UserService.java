package com.ynov.sofiane.services;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface UserService {
    @Autowired
    User createUser(User entity);
    void giveRoleToUser(User user, Role role);

    Optional<User> getUserByFullname(String fullname);
    Optional<User> getUserByEmail(String email);

}
