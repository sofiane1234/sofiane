package com.ynov.sofiane.implems;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.repositories.UserRepo;
import com.ynov.sofiane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImplem implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public void giveRoleToUser(User user, Role role) {
        user.addRole(role);
        userRepo.save(user);
    }
    @Override
    public User createUser(User entity) {
        return userRepo.save(entity);
    }
}
