package com.ynov.sofiane.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;

    @Email(message = "Invalid email address")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    private Boolean valid;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<Article> stock;


    public void giveRole(Role role) {
        getRoles().add(role);
    }
}
