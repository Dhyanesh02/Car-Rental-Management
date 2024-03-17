package com.dhyaneshcodespace.Car_Rental_Service.services.auth;

import com.dhyaneshcodespace.Car_Rental_Service.dto.SignupRequest;
import com.dhyaneshcodespace.Car_Rental_Service.dto.UserDto;


public interface AuthService{
    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
}
