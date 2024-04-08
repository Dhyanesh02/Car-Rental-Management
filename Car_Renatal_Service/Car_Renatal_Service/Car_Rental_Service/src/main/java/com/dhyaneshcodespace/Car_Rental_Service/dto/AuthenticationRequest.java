package com.dhyaneshcodespace.Car_Rental_Service.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
