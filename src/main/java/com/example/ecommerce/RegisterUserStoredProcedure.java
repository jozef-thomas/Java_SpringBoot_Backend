package com.example.ecommerce;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class RegisterUserStoredProcedure extends StoredProcedure {
    private static final String REGISTER_PROCEDURE_NAME = "register_user_19751";

    public RegisterUserStoredProcedure(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, REGISTER_PROCEDURE_NAME);

        // Register the parameters for the stored procedure
        declareParameter(new SqlParameter("username", Types.VARCHAR));
        declareParameter(new SqlParameter("password", Types.VARCHAR));
        declareParameter(new SqlOutParameter("errorCode", Types.INTEGER));
        declareParameter(new SqlOutParameter("errorMessage", Types.VARCHAR));

        // Compile the stored procedure
        compile();
    }

    public Map<String, Object> executeRegisterUser(String username, String password) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("username", username);
        inParams.put("password", password);
        return execute(inParams);
    }
}
