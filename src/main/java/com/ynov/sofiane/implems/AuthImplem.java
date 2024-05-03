package com.ynov.sofiane.implems;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.services.AuthService;
import com.ynov.sofiane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthImplem implements AuthService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Override
    public String login(User user, String password) {
        bCryptPasswordEncoder.matches(password, user.getPassword());
        return null;
    }

    @Override
    public User register(User entity, Role role) {
        String passwordEncoded = bCryptPasswordEncoder.encode(entity.getPassword());
        entity.setPassword(passwordEncoded);
        userService.giveRoleToUser(entity, role);
        return userService.createUser(entity);
    }
}
