package com.example.ecommerce.service;

import java.util.Map;

import com.example.ecommerce.entity.UserDB;

public interface EcommerceService {
   Map<String, Object> registerUser(UserDB user);
   Map<String, Object> loginUser(UserDB user);
}
