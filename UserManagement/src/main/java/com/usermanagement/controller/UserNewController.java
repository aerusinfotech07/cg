package com.usermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/newUsers")
public class UserNewController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String greet()
	{
		return "Welcome to the world of Users Data";
	}
	
	//http:localhost:8090/newUsers/list
	@GetMapping("/list")
	public ResponseEntity<?> getAllUsers()
	{
		List<User> userList=userService.getAllUsers();
		if(null!=userList && userList.size()==0) {
			 Map<String, String> error = new HashMap<>();
			 error.put("message", "No Records Available in database");
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error);
		}
		else
			return ResponseEntity.ok(userList);
	}
	
	//http:localhost:8090/newUsers/101
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id)
	{
		Optional<User> user=userService.getUserById(id);
		if(user.isPresent())
			return ResponseEntity.ok(user.get());
		else {
			 Map<String, String> error = new HashMap<>();
	            error.put("message", "User not found with id: " + id);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
		
	}
	
	
	
	public ResponseEntity<?> createUser(
            @Valid @RequestBody User user) {
		
		
	}
	
	
	
}
