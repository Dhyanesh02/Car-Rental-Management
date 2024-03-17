package com.dhyaneshcodespace.Car_Rental_Service.dto;

import com.dhyaneshcodespace.Car_Rental_Service.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
