package com.ynov.sofiane.services;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.repositories.UserRepo;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService {
    @Autowired
    private UserRepo userRepo;

    Optional<User>getUserById(Long id);
    User createUser(User entity);
    public User updateUser(Long userId, User updatedUser, User currentUser) throws Exception {
        if (currentUser.getRoles().equals("ADMIN")) {
            if (userRepo.existsById(userId)) {
                updatedUser.setId(userId);
                return userRepo.save(updatedUser);
            } else {
                throw new Exception("User not found");
            }
        } else {
            throw new Exception("User is not Admin : UNAUTHORIZED");
        }

    }
    public void deleteUser(Long userId, User currentUser) throws Exception {
        if (currentUser.getRoles().equals("ADMIN")) {
            userRepo.deleteById(userId);
        } else {
            throw new Exception("User is not Admin : UNAUTHORIZED!");
        }
    }

}
