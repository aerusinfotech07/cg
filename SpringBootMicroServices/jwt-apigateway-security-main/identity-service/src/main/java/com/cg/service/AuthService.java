package com.cg.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.entity.Role;
import com.cg.entity.UserCredential;
import com.cg.repository.RoleRepository;
import com.cg.repository.UserCredentialRepository;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
       
     // Assign roles
        Role userRole = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        credential.setRoles(roles);
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username, Set<Role> roles) {
        return jwtService.generateToken(username,roles);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
    
    public Set<Role> getUserRoles(String username) {
        UserCredential user = repository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Assuming the UserCredential entity has a `roles` field storing roles as a list
        return user.getRoles(); // Replace with your implementation to fetch roles
    }


}
