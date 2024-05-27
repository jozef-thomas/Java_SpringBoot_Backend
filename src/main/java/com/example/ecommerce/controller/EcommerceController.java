package com.example.ecommerce.controller;

import com.example.ecommerce.entity.UserDB;
import com.example.ecommerce.service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EcommerceController {

    @Autowired
    private EcommerceService ecommerceService;

    // @PostMapping("/api/register")
    // public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Map<String, String> userData) {
    //     String username = userData.get("username");
    //     String password = userData.get("password");
    //     Map<String, Object> response = ecommerceService.registerUser(username, password);
    //     return new ResponseEntity<>(response, HttpStatus.CREATED);
    // }

    @PostMapping("/register")
public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDB user) {
    // Call the registerUser method from ecommerceService
    Map<String, Object> response = ecommerceService.registerUser(user);

    // Return the response entity with the appropriate status code
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

    // @PostMapping("/api/login")
    // public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> credentials) {
    //     String username = credentials.get("username");
    //     String password = credentials.get("password");
    //     Map<String, Object> response = ecommerceService.loginUser(username, password);
    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }

@PostMapping("/login")
public ResponseEntity<Map<String, Object>> loginUser(@RequestBody UserDB user) {
    // Call the loginUser method from ecommerceService
    Map<String, Object> response = ecommerceService.loginUser(user);

    // Return the response entity with the appropriate status code
    return new ResponseEntity<>(response, HttpStatus.OK);
}
}
