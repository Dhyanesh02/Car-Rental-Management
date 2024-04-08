package com.dhyaneshcodespace.Car_Rental_Service.repository;

import com.dhyaneshcodespace.Car_Rental_Service.entity.User;
import com.dhyaneshcodespace.Car_Rental_Service.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
