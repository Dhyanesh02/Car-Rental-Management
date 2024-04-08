package com.dhyaneshcodespace.Car_Rental_Service.dto;

import lombok.Data;


@Data
public class SignupRequest {
    private String email;
    private String name;
    private String password;
}
