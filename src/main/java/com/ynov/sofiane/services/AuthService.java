package com.ynov.sofiane.services;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;

public interface AuthService {
    String login(User user, String password);
    User register(User entity, Role admin);
}
