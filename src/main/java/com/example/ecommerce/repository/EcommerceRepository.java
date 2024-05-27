package com.example.ecommerce.repository;

import com.example.ecommerce.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EcommerceRepository extends JpaRepository<UserDB, Long> {
    Optional<UserDB> findByUsername(String username);
}
