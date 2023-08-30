package com.isaac.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.isaac.model.Users;
import com.isaac.service.UserService;

@Controller
//@RequestMapping("/users")
public class SignUpController {
	 @Autowired
private UserService userService;

 @PostMapping("/signup")

   public ResponseEntity<String> registerUser(@RequestBody Users users) {
	   try {
		         
		   userService.registerUser(users);   
		   return ResponseEntity.ok("User registered successfully!");
		        } catch (Exception e) {
		            // Handle any exceptions here, e.g., database errors, validation errors.
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                .body("Registration failed: " + e.getMessage());
		        }
		    }
		}
