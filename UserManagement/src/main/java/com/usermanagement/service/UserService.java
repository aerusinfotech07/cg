package com.usermanagement.service;

import com.usermanagement.entity.User;
import com.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User createUser(User user) {
        // Check if username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }
        
        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        
        return userRepository.save(user);
    }
    
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        // Check if username is being changed and if it already exists
        if (!user.getUsername().equals(userDetails.getUsername()) && 
            userRepository.existsByUsername(userDetails.getUsername())) {
            throw new RuntimeException("Username already exists: " + userDetails.getUsername());
        }
        
        // Check if email is being changed and if it already exists
        if (!user.getEmail().equals(userDetails.getEmail()) && 
            userRepository.existsByEmail(userDetails.getEmail())) {
            throw new RuntimeException("Email already exists: " + userDetails.getEmail());
        }
        
        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setWebsite(userDetails.getWebsite());
        
        // Update nested objects
        if (userDetails.getAddress() != null) {
            if (user.getAddress() != null) {
                user.getAddress().setStreet(userDetails.getAddress().getStreet());
                user.getAddress().setSuite(userDetails.getAddress().getSuite());
                user.getAddress().setCity(userDetails.getAddress().getCity());
                user.getAddress().setZipcode(userDetails.getAddress().getZipcode());
                
                if (userDetails.getAddress().getGeo() != null && user.getAddress().getGeo() != null) {
                    user.getAddress().getGeo().setLat(userDetails.getAddress().getGeo().getLat());
                    user.getAddress().getGeo().setLng(userDetails.getAddress().getGeo().getLng());
                }
            } else {
                user.setAddress(userDetails.getAddress());
            }
        }
        
        if (userDetails.getCompany() != null) {
            if (user.getCompany() != null) {
                user.getCompany().setName(userDetails.getCompany().getName());
                user.getCompany().setCatchPhrase(userDetails.getCompany().getCatchPhrase());
                user.getCompany().setBs(userDetails.getCompany().getBs());
            } else {
                user.setCompany(userDetails.getCompany());
            }
        }
        
        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        userRepository.delete(user);
    }
    
    public boolean userExists(Long id) {
        return userRepository.existsById(id);
    }
}
