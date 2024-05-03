package com.ynov.sofiane.controllers;

import com.ynov.sofiane.models.Role;
import com.ynov.sofiane.models.User;
import com.ynov.sofiane.repositories.RoleRepo;
import com.ynov.sofiane.services.AuthService;
import com.ynov.sofiane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    RoleRepo roleRepo;

    private ResponseEntity<?> userExists (User entity) {
        Optional<User> user = userService.getUserByFullname(entity.getFullname());
        if (user.isPresent())
            return new ResponseEntity<>(
                    "fullname already exists",
                    HttpStatus.CONFLICT
            );
        return null;
    }

    @PostMapping("admin/signup")
    public ResponseEntity<?> adminRegister(@RequestBody User entity) {
        ResponseEntity<?> res = userExists(entity);
        if (res != null)
            return res;
        Optional<Role> role = roleRepo.findByRoleName(Role.RoleName.ADMIN.name());
            if (role.isEmpty())
                return new ResponseEntity<>(
                        "Erreur!",
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
        return new ResponseEntity<>(
                authService.register(entity, role.get()),
                HttpStatus.CREATED
        );
    }

    @PostMapping("user/signup")
    public ResponseEntity<?> userRegister(@RequestBody User entity) {
        ResponseEntity<?> res = userExists(entity);
        if (res != null)
            return res;
        Optional<Role> role = roleRepo.findByRoleName(Role.RoleName.USER.name());
        if (role.isEmpty())
            return new ResponseEntity<>(
                    "Erreur!",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        return new ResponseEntity<>(
                authService.register(entity, role.get()),
                HttpStatus.CREATED
        );
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        String email = req.get("email");
        String password = req.get("password");
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isEmpty())
            return new ResponseEntity<>(
                    "Utilisateur inexistant",
                    HttpStatus.NOT_FOUND
            );
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }
}
