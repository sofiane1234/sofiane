package com.ynov.sofiane.services;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    @Autowired
    User createUser(User entity);
    void giveRoleToUser(User user, Role role);
}
