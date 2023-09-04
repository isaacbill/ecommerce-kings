package com.isaac.controller;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
 @PostMapping("/login")
 public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
     String email = loginData.get("email");
     String password = loginData.get("password");

     Users users = userService.loginUser(email, password);

     if (users != null) {
         return ResponseEntity.ok("Login successful!"); // Return success message
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
             .body("Invalid email or password"); // Return error message
     }
 }
 
// @PostMapping("/reset")
// public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> resetData) {
//     String email = resetData.get("email");
//     String token = resetData.get("token");
//     String newPassword = resetData.get("newPassword");
//
//     if (userService.isPasswordResetTokenValid(email, token)) {
//         userService.resetPassword(email, newPassword);
//         userService.invalidatePasswordResetToken(email);
//         return ResponseEntity.ok("Password reset successfully.");
//     } else {
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//             .body("Invalid or expired token.");
//     }
// }
 @PostMapping("/generate-token")
 public ResponseEntity<String> generatePasswordResetToken(@RequestParam(required = true) String email) {
     String token = UUID.randomUUID().toString();
     LocalDateTime expiration = LocalDateTime.now().plusHours(1);
     userService.generatePasswordResetToken(email, token, expiration);

     // Send an email to the user with the reset token link
     // This step is typically handled by an email service

     return ResponseEntity.ok("Reset token generated and sent to your email.");
 }

 @PostMapping("/reset")
 public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> resetData) {
     String email = resetData.get("email");
     String token = resetData.get("token");
     String newPassword = resetData.get("newPassword");

     if (userService.isPasswordResetTokenValid(email, token)) {
         userService.resetPassword(email, newPassword);
         userService.invalidatePasswordResetToken(email);
         return ResponseEntity.ok("Password reset successfully.");
     } else {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
             .body("Invalid or expired token.");
     }
 }


}
