package com.dhyaneshcodespace.Car_Rental_Service.dto;

import com.dhyaneshcodespace.Car_Rental_Service.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private UserRole userRole;
}
