package com.ynov.sofiane.implems;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.repositories.UserRepo;
import com.ynov.sofiane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImplem implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public void giveRoleToUser(User user, Role role) {
        user.giveRole(role);
        userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByFullname(String fullname) {
        return UserRepo.findByFullname(fullname);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return UserRepo.findByEmail();
    }

    @Override
    public User createUser(User entity) {
        return userRepo.save(entity);
    }
}
