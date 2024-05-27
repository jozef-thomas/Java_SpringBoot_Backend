package com.example.ecommerce.service.Implementation;

import com.example.ecommerce.RegisterUserStoredProcedure;
import com.example.ecommerce.LoginUserStoredProcedure;
import com.example.ecommerce.entity.UserDB;
import com.example.ecommerce.repository.EcommerceRepository;
import com.example.ecommerce.service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EcommerceServiceImpl implements EcommerceService {

    @Autowired
    private EcommerceRepository ecommerceRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> registerUser(UserDB user) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Call the stored procedure for user registration
            RegisterUserStoredProcedure storedProcedure = new RegisterUserStoredProcedure(jdbcTemplate);
            Map<String, Object> output = storedProcedure.executeRegisterUser(user.getUsername(), user.getPassword());

            // Process output and set response accordingly
            // For example:
            int errorCode = (int) output.get("errorCode");
            if (errorCode == 0) {
                response.put("errorCode", 0);
                response.put("errorMessage", "User registered successfully");
            } else {
                response.put("errorCode", 1);
                response.put("errorMessage", "Failed to register user");
            }
        } catch (Exception e) {
            response.put("errorCode", 1);
            response.put("errorMessage", "Failed to register user");
        }
        return response;
    }

    @Override
    public Map<String, Object> loginUser(UserDB user) {
        Map<String, Object> response = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            // Call the stored procedure for user login
            LoginUserStoredProcedure storedProcedure = new LoginUserStoredProcedure(jdbcTemplate);
            Map<String, Object> output = storedProcedure.executeLoginUser(username, password);

            // Process output and set response accordingly
            // For example:
            int errorCode = (int) output.get("errorCode");
            if (errorCode == 0) {
                response.put("errorCode", 0);
                response.put("errorMessage", "Login successful");
            } else {
                response.put("errorCode", 1);
                response.put("errorMessage", "Incorrect username or password");
            }
        } catch (Exception e) {
            response.put("errorCode", 1);
            response.put("errorMessage", "Failed to login user");
        }
        return response;
    }
}


    